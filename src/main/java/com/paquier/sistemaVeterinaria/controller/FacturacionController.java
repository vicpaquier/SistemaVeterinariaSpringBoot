package com.paquier.sistemaVeterinaria.controller;

import com.paquier.sistemaVeterinaria.dto.FacturacionDto;
import com.paquier.sistemaVeterinaria.dto.Mensaje;
import com.paquier.sistemaVeterinaria.entity.Facturacion;
import com.paquier.sistemaVeterinaria.service.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/facturacion")
public class FacturacionController {
    @Autowired
    private FacturacionService facturacionService;

    @GetMapping("/listar")
    public ResponseEntity<List<Facturacion>> listar(){
        List<Facturacion> estadoAgendamientos = facturacionService.obtenerTodos();
        return new ResponseEntity<>(estadoAgendamientos, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<FacturacionDto> obtenerPorId(@PathVariable("id") long id){
        if(!facturacionService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe la facturacion con id "+id), HttpStatus.BAD_REQUEST);
        }

        Facturacion facturacion = facturacionService.obtenerPorId(id).get();

        FacturacionDto responseFacturacion = new FacturacionDto();
        responseFacturacion.setIdFacturacion(facturacion.getIdFacturacion());
        responseFacturacion.setCondicion(facturacion.getCondicion());
        responseFacturacion.setEstado(facturacion.getEstado());
        responseFacturacion.setCliente(facturacion.getCliente());
        responseFacturacion.setFecha(facturacion.getFecha());
        responseFacturacion.setUsuario(facturacion.getUsuario());
        responseFacturacion.setNumero(facturacion.getNumero());


        return new ResponseEntity<>(responseFacturacion, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Facturacion> crear(@RequestBody FacturacionDto facturacionDto){
        Facturacion responseFacturacion = new Facturacion();

        responseFacturacion.setCliente(facturacionDto.getCliente());
        responseFacturacion.setIdFacturacion(facturacionDto.getIdFacturacion());
        responseFacturacion.setCondicion(facturacionDto.getCondicion());
        responseFacturacion.setFecha(facturacionDto.getFecha());
        responseFacturacion.setUsuario(facturacionDto.getUsuario());
        responseFacturacion.setNumero(facturacionDto.getNumero());
        responseFacturacion.setEstado(facturacionDto.getEstado());

        facturacionService.crear(responseFacturacion);

        return new ResponseEntity<>(responseFacturacion, HttpStatus.OK);

    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Facturacion> modificar(@PathVariable("id") long id, @RequestBody FacturacionDto facturacionDto){
        if(!facturacionService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe la facturacion con id "+id), HttpStatus.BAD_REQUEST);
        }
        Facturacion responseFacturacion = facturacionService.obtenerPorId(id).get();
        responseFacturacion.setEstado(facturacionDto.getEstado());
        responseFacturacion.setNumero(facturacionDto.getNumero());
        responseFacturacion.setIdFacturacion(id);
        responseFacturacion.setCliente(facturacionDto.getCliente());
        responseFacturacion.setFecha(facturacionDto.getFecha());
        responseFacturacion.setUsuario(facturacionDto.getUsuario());
        responseFacturacion.setCondicion(facturacionDto.getCondicion());

        facturacionService.crear(responseFacturacion);
        return new ResponseEntity<>(responseFacturacion, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable("id") long id){
        if(!facturacionService.existePorId(id)){
            return new ResponseEntity<>(new Mensaje("No existe la facturacion con id "+id), HttpStatus.BAD_REQUEST);
        }
        facturacionService.eliminar(id);
        return new ResponseEntity<>(new Mensaje("Se ha eliminado la facturacion con id "+id), HttpStatus.OK);
    }
}
