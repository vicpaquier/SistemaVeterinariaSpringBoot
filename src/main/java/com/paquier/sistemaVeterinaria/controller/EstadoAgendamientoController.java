package com.paquier.sistemaVeterinaria.controller;

import com.paquier.sistemaVeterinaria.dto.EstadoAgendamientoDto;
import com.paquier.sistemaVeterinaria.dto.Mensaje;
import com.paquier.sistemaVeterinaria.entity.EstadoAgendamiento;
import com.paquier.sistemaVeterinaria.service.EstadoAgendamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estadoAgendamiento")
public class EstadoAgendamientoController {
    @Autowired
    private EstadoAgendamientoService estadoAgendamientoService;

    @GetMapping("/listar")
    public ResponseEntity<List<EstadoAgendamiento>> listar(){
        List<EstadoAgendamiento> estadoAgendamientos = estadoAgendamientoService.obtenerTodos();
        return new ResponseEntity<>(estadoAgendamientos, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<EstadoAgendamientoDto> obtenerPorId(@PathVariable("id") long id){
        if(!estadoAgendamientoService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe el estado de agendamiento con id "+id), HttpStatus.BAD_REQUEST);
        }

        EstadoAgendamiento estadoAgendamiento = estadoAgendamientoService.obtenerPorId(id).get();

        EstadoAgendamientoDto responseEstadoAgendamiento = new EstadoAgendamientoDto();
        responseEstadoAgendamiento.setIdEstadoAgendamiento(estadoAgendamiento.getIdEstadoAgendamiento());
        responseEstadoAgendamiento.setDescripcion(estadoAgendamiento.getDescripcion());

        return new ResponseEntity<>(responseEstadoAgendamiento, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<EstadoAgendamiento> crear(@RequestBody EstadoAgendamientoDto estadoAgendamientoDto){
        EstadoAgendamiento responseEstadoAgendamiento = new EstadoAgendamiento();

        responseEstadoAgendamiento.setDescripcion(estadoAgendamientoDto.getDescripcion());

        estadoAgendamientoService.crear(responseEstadoAgendamiento);

        return new ResponseEntity<>(responseEstadoAgendamiento, HttpStatus.OK);

    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<EstadoAgendamiento> modificar(@PathVariable("id") long id, @RequestBody EstadoAgendamientoDto estadoAgendamientoDto){
        if(!estadoAgendamientoService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe el estado de agendamiento con id "+id), HttpStatus.BAD_REQUEST);
        }
        EstadoAgendamiento responseEstadoAgendamiento = estadoAgendamientoService.obtenerPorId(id).get();
        responseEstadoAgendamiento.setDescripcion(estadoAgendamientoDto.getDescripcion());

        estadoAgendamientoService.crear(responseEstadoAgendamiento);
        return new ResponseEntity<>(responseEstadoAgendamiento, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable("id") long id){
        if(!estadoAgendamientoService.existePorId(id)){
            return new ResponseEntity<>(new Mensaje("No existe un estado de agendmiento con id "+id), HttpStatus.BAD_REQUEST);
        }
        estadoAgendamientoService.eliminar(id);
        return new ResponseEntity<>(new Mensaje("Se ha eliminado el estado de agendamiento con id "+id), HttpStatus.OK);
    }
}
