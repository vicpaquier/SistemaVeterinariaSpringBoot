package com.paquier.sistemaVeterinaria.controller;

import com.paquier.sistemaVeterinaria.dto.ClienteDto;
import com.paquier.sistemaVeterinaria.dto.Mensaje;
import com.paquier.sistemaVeterinaria.entity.Cliente;
import com.paquier.sistemaVeterinaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

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

        clienteService.eliminar(id);

        return new ResponseEntity<>(new Mensaje("Se ha eliminado correctamente el cliente con id "+id), HttpStatus.OK);
    }
}
