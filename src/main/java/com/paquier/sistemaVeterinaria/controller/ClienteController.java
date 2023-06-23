package com.paquier.sistemaVeterinaria.controller;

import com.paquier.sistemaVeterinaria.dto.ClienteDto;
import com.paquier.sistemaVeterinaria.dto.Mensaje;
import com.paquier.sistemaVeterinaria.entity.Cliente;
import com.paquier.sistemaVeterinaria.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    private final Logger log = LoggerFactory.getLogger(ClienteController.class);

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listar(){
        List<Cliente> clientes = clienteService.obtenerTodos();

        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<ClienteDto> obtenerPorId(@PathVariable("id")Long id){
        if(!clienteService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe el empleado con id "+id), HttpStatus.NOT_FOUND);
        }

        Cliente cliente = clienteService.obtenerPorId(id).get();

        ClienteDto responseCliente = new ClienteDto();
        responseCliente.setIdCliente(cliente.getIdCliente());
        responseCliente.setApellido((cliente.getApellido()));
        responseCliente.setNombre(cliente.getNombre());
        responseCliente.setCelular((cliente.getCelular()));
        responseCliente.setRuc(cliente.getRuc());

        return new ResponseEntity<>(responseCliente, HttpStatus.CREATED);
    }

    @GetMapping("/detalle/ruc/{ruc}")
    public ResponseEntity<ClienteDto> obtenerPorRuc(@PathVariable("ruc")String ruc){
        if(!clienteService.existePorRuc(ruc)){
            return new ResponseEntity(new Mensaje("No existe el empleado con RUC "+ruc), HttpStatus.NOT_FOUND);
        }

        Cliente cliente = clienteService.obtenerPorRuc(ruc).get();

        ClienteDto responseCliente = new ClienteDto();
        responseCliente.setIdCliente(cliente.getIdCliente());
        responseCliente.setApellido((cliente.getApellido()));
        responseCliente.setNombre(cliente.getNombre());
        responseCliente.setCelular((cliente.getCelular()));
        responseCliente.setRuc(cliente.getRuc());

        return new ResponseEntity<>(responseCliente, HttpStatus.CREATED);
    }

    @PostMapping("/crear")
    public ResponseEntity<Cliente> crear(@RequestBody ClienteDto cliente){
        if(clienteService.existePorRuc(cliente.getRuc())){
            return new ResponseEntity(new Mensaje("Ya existe un cliente con el RUC "+cliente.getRuc()), HttpStatus.NOT_ACCEPTABLE);
        }
        if(clienteService.existePorCelular(cliente.getCelular())){
            return new ResponseEntity(new Mensaje("Ya existe un cliente con el celular "+cliente.getCelular()), HttpStatus.NOT_ACCEPTABLE);
        }

        Cliente responseCliente = new Cliente();
        responseCliente.setApellido(cliente.getApellido());
        responseCliente.setNombre(cliente.getNombre());
        responseCliente.setCelular(cliente.getCelular());
        responseCliente.setRuc(cliente.getRuc());

        clienteService.crear(responseCliente);
        return new ResponseEntity<>(responseCliente, HttpStatus.CREATED);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Cliente> crear(@PathVariable Long id, @RequestBody ClienteDto cliente){
        if(!clienteService.existePorId(id)){
            return new ResponseEntity(new Mensaje("El cliente con id  "+cliente.getIdCliente()+" no existe"), HttpStatus.BAD_REQUEST);
        }

        Cliente responseCliente = clienteService.obtenerPorId(id).get();

        responseCliente.setApellido(cliente.getApellido());
        responseCliente.setNombre(cliente.getNombre());
        responseCliente.setCelular(cliente.getCelular());
        responseCliente.setRuc(cliente.getRuc());

        clienteService.crear(responseCliente);
        return new ResponseEntity<>(responseCliente, HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable("id") Long id){

        if(!clienteService.existePorId(id)){
            return new ResponseEntity<>(new Mensaje("No existe el cliente con id "+id), HttpStatus.BAD_REQUEST);
        }

        Cliente cliente = clienteService.obtenerPorId(id).get();

        String nombreFotoAnterior = cliente.getFoto();

        if(nombreFotoAnterior != null && nombreFotoAnterior.length()>0){
            Path rutaFotoAnterior = Paths.get("uploads").resolve((nombreFotoAnterior)).toAbsolutePath();

            File archivoFotoAnterior = rutaFotoAnterior.toFile();

            if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()){
                archivoFotoAnterior.delete();
            }
        }

        clienteService.eliminar(id);

        return new ResponseEntity<>(new Mensaje("Se ha eliminado correctamente el cliente con id "+id), HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){

        Cliente cliente = clienteService.obtenerPorId(id).get();
        //confirmar que el nombre sera unico
        String nombreArchivo = UUID.randomUUID().toString() + "_" +archivo.getOriginalFilename().replace(" ","-");

        if(!archivo.isEmpty()){
            //ruta absoluta
            Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
            //log de ruta del archivo
            log.info(rutaArchivo.toString());

            try{
                Files.copy(archivo.getInputStream(), rutaArchivo);

            } catch (IOException e){
                e.printStackTrace();
                return new ResponseEntity<>(new Mensaje("Error al subir la imagen"), HttpStatus.INTERNAL_SERVER_ERROR);
            }

            String nombreFotoAnterior = cliente.getFoto();

            if(nombreFotoAnterior != null && nombreFotoAnterior.length()>0){
                Path rutaFotoAnterior = Paths.get("uploads").resolve((nombreFotoAnterior)).toAbsolutePath();

                File archivoFotoAnterior = rutaFotoAnterior.toFile();

                if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()){
                    archivoFotoAnterior.delete();
                }
            }


            cliente.setFoto(nombreArchivo);

            clienteService.crear(cliente);
            return new ResponseEntity<>(new Mensaje("Se ha subido correctamente la imagen " + nombreArchivo), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Mensaje("Error al subir la imagen"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //la ruta contiene una exprosion regular que indica que el pathVariable tendra un "." y la extension
    @GetMapping("/uploads/img/{nombreFoto:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
        Path rutaArchivo = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath() ;
        Resource recurso = null;
        //log de ruta del archivo
        log.info(rutaArchivo.toString());
        try {
            recurso = new UrlResource(rutaArchivo.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();

        }

        if(!recurso.exists() && !recurso.isReadable()){
            throw new RuntimeException("Error no se pudo cargar la imagen " + nombreFoto);
        }

        HttpHeaders cabecera = new HttpHeaders();
        //para que se pueda descargar la imagen y se pueda usar en una etiquete <img src=>
        cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+recurso.getFilename()+"\"");

        return new ResponseEntity<>(recurso, cabecera, HttpStatus.OK);

    }
}
