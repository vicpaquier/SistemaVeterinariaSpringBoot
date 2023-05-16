package com.paquier.sistemaVeterinaria.controller;

import com.paquier.sistemaVeterinaria.dto.Mensaje;
import com.paquier.sistemaVeterinaria.dto.ServicioDto;
import com.paquier.sistemaVeterinaria.entity.Servicio;
import com.paquier.sistemaVeterinaria.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/servicio")
public class ServicioController {
    @Autowired
    private ServicioService servicioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Servicio>> listar(){
        List<Servicio> responseServicios = servicioService.obtenerTodos();

        return new ResponseEntity<>(responseServicios, HttpStatus.OK);

    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<ServicioDto> obtenerPorId(@PathVariable("id") Long id){
        if(!servicioService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe el servicio con id "+id), HttpStatus.BAD_REQUEST);
        }

        Servicio servicio = servicioService.obtenerPorId(id).get();

        ServicioDto responseServicio = new ServicioDto();
        responseServicio.setDescripcion(servicio.getDescripcion());
        responseServicio.setIva(servicio.getIva());
        responseServicio.setPrecio(servicio.getPrecio());
        responseServicio.setIdServicio(servicio.getIdServicio());

        return new ResponseEntity<>(responseServicio, HttpStatus.OK);
    }


    @PostMapping("/crear")
    public ResponseEntity<Servicio> crear(@RequestBody ServicioDto servicio){
        Servicio responseServicio = new Servicio();
        responseServicio.setDescripcion(servicio.getDescripcion());
        responseServicio.setIva(servicio.getIva());
        responseServicio.setPrecio(servicio.getPrecio());


        servicioService.crear(responseServicio);

        return new ResponseEntity<>(responseServicio, HttpStatus.CREATED);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Servicio> modificar(@PathVariable("id") Long id, @RequestBody ServicioDto servicioDto){
        if (!servicioService.existePorId(id)) {
            return new ResponseEntity(new Mensaje("No existe el servicio con id "+id), HttpStatus.BAD_REQUEST);
        }

        Servicio responseServicio = servicioService.obtenerPorId(id).get();

        responseServicio.setPrecio(servicioDto.getPrecio());
        responseServicio.setIva(servicioDto.getIva());
        responseServicio.setDescripcion(servicioDto.getDescripcion());

        servicioService.crear(responseServicio);

        return new ResponseEntity<>(responseServicio, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable("id") Long id){
        if(!servicioService.existePorId(id)){
            return new ResponseEntity<>(new Mensaje("No existe el servicio con id "+id), HttpStatus.OK);
        }
        servicioService.eliminar(id);
        return new ResponseEntity<>(new Mensaje("Se ha eliminado el servicio con id "+id), HttpStatus.OK);
    }
}
