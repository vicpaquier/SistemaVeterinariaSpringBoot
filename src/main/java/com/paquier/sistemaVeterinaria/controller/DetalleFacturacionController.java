package com.paquier.sistemaVeterinaria.controller;

import com.paquier.sistemaVeterinaria.dto.DetalleFacturacionDto;
import com.paquier.sistemaVeterinaria.dto.Mensaje;
import com.paquier.sistemaVeterinaria.entity.DetalleFacturacion;
import com.paquier.sistemaVeterinaria.service.DetalleFacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/detallefacturacion")
public class DetalleFacturacionController {
    @Autowired
    private DetalleFacturacionService detalleFacturacionService;

    @GetMapping("/listar")
    public ResponseEntity<List<DetalleFacturacion>> listar(){
        List<DetalleFacturacion> detalleFacturacions = detalleFacturacionService.obtenerTodos();
        return new ResponseEntity<>(detalleFacturacions, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<DetalleFacturacionDto> obtenerPorId(@PathVariable("id") long id){
        if(!detalleFacturacionService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe el detalle de facturacion con id "+id), HttpStatus.BAD_REQUEST);
        }

        DetalleFacturacion detalleFacturacion = detalleFacturacionService.obtenerPorId(id).get();

        DetalleFacturacionDto resposeDetalleFacturacion= new DetalleFacturacionDto();
        resposeDetalleFacturacion.setFacturacion(detalleFacturacion.getFacturacion());
        resposeDetalleFacturacion.setCantidad(detalleFacturacion.getCantidad());
        resposeDetalleFacturacion.setServicio(detalleFacturacion.getServicio());
        resposeDetalleFacturacion.setIdDetalleFacturacion(detalleFacturacion.getIdDetalleFacturacion());

        return new ResponseEntity<>(resposeDetalleFacturacion, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<DetalleFacturacion> crear(@RequestBody DetalleFacturacionDto detalleFacturacionDto){
        DetalleFacturacion responseDetalleFacturacion = new DetalleFacturacion();

        responseDetalleFacturacion.setFacturacion(detalleFacturacionDto.getFacturacion());
        responseDetalleFacturacion.setIdDetalleFacturacion(detalleFacturacionDto.getIdDetalleFacturacion());
        responseDetalleFacturacion.setCantidad(detalleFacturacionDto.getCantidad());
        responseDetalleFacturacion.setCantidad(detalleFacturacionDto.getCantidad());

        detalleFacturacionService.crear(responseDetalleFacturacion);

        return new ResponseEntity<>(responseDetalleFacturacion, HttpStatus.OK);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<DetalleFacturacion> modificar(@PathVariable("id") long id, @RequestBody DetalleFacturacionDto detalleFacturacionDto){
        if(!detalleFacturacionService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe el detalle de facturacion con id "+id), HttpStatus.BAD_REQUEST);
        }
        DetalleFacturacion responseDetalleFacturacion = detalleFacturacionService.obtenerPorId(id).get();
        responseDetalleFacturacion.setCantidad(detalleFacturacionDto.getCantidad());
        responseDetalleFacturacion.setServicio(detalleFacturacionDto.getServicio());
        responseDetalleFacturacion.setFacturacion(detalleFacturacionDto.getFacturacion());
        responseDetalleFacturacion.setIdDetalleFacturacion(id);

        detalleFacturacionService.crear(responseDetalleFacturacion);
        return new ResponseEntity<>(responseDetalleFacturacion, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable("id") long id){
        if(!detalleFacturacionService.existePorId(id)){
            return new ResponseEntity<>(new Mensaje("No existe el detalle de facturacion con id "+id), HttpStatus.BAD_REQUEST);
        }
        detalleFacturacionService.eliminar(id);
        return new ResponseEntity<>(new Mensaje("Se ha eliminado el detalle de facturacion con id "+id), HttpStatus.OK);
    }
}
