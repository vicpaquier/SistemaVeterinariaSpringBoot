package com.paquier.sistemaVeterinaria.controller;

import com.paquier.sistemaVeterinaria.dto.AgendamientoDto;
import com.paquier.sistemaVeterinaria.dto.Mensaje;
import com.paquier.sistemaVeterinaria.entity.Agendamiento;
import com.paquier.sistemaVeterinaria.service.AgendamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/agendamiento")
public class AgendamientoController {
    @Autowired
    private AgendamientoService agendamientoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Agendamiento>> listar(){
        List<Agendamiento> agendamientos = agendamientoService.obtenerTodos();
        return new ResponseEntity<>(agendamientos, HttpStatus.OK);
    }

    @GetMapping("detalle/{id}")
    public ResponseEntity<AgendamientoDto> obtenerPorId(@PathVariable("id")long id){
        if(!agendamientoService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe el agendamiento con id "+id), HttpStatus.BAD_REQUEST);
        }

        Agendamiento agendamiento = agendamientoService.obtenerPorId(id).get();
        AgendamientoDto responseAgendamiento = new AgendamientoDto();
        responseAgendamiento.setIdAgendamiento(agendamiento.getIdAgendamiento());
        responseAgendamiento.setEstadoAgendamiento(agendamiento.getEstadoAgendamiento());
        responseAgendamiento.setCliente(agendamiento.getCliente());
        responseAgendamiento.setEmpleado(agendamiento.getEmpleado());
        responseAgendamiento.setFecha(agendamiento.getFecha());

        return new ResponseEntity<>(responseAgendamiento, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Agendamiento> crear(@RequestBody AgendamientoDto agendamientoDto){
        Agendamiento responseAgendamiento = new Agendamiento();

        responseAgendamiento.setCliente(agendamientoDto.getCliente());
        responseAgendamiento.setEstadoAgendamiento(agendamientoDto.getEstadoAgendamiento());
        responseAgendamiento.setEmpleado(agendamientoDto.getEmpleado());
        responseAgendamiento.setFecha(agendamientoDto.getFecha());

        agendamientoService.crear(responseAgendamiento);

        return new ResponseEntity<>(responseAgendamiento, HttpStatus.OK);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Agendamiento>  modificar(@PathVariable("id")long id, @RequestBody AgendamientoDto agendamientoDto){
        if(!agendamientoService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe el agendamiento con id "+id), HttpStatus.BAD_REQUEST);
        }

        Agendamiento responseAgendamiento = agendamientoService.obtenerPorId(id).get();

        responseAgendamiento.setFecha(agendamientoDto.getFecha());
        responseAgendamiento.setEmpleado(agendamientoDto.getEmpleado());
        responseAgendamiento.setEstadoAgendamiento(agendamientoDto.getEstadoAgendamiento());
        responseAgendamiento.setCliente(agendamientoDto.getCliente());

        agendamientoService.crear(responseAgendamiento);

        return new ResponseEntity<>(responseAgendamiento, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable("id")long id){
        if(!agendamientoService.existePorId(id)){
            return new ResponseEntity<>(new Mensaje("No existe el agendamiento con id "+id), HttpStatus.BAD_REQUEST);
        }
        agendamientoService.eliminar(id);
        return new ResponseEntity<>(new Mensaje("Se ha eliminado el agendamiento con id "+id), HttpStatus.OK);
    }
}
