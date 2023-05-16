package com.paquier.sistemaVeterinaria.controller;

import com.paquier.sistemaVeterinaria.dto.EmpleadoDto;
import com.paquier.sistemaVeterinaria.dto.Mensaje;
import com.paquier.sistemaVeterinaria.entity.Empleado;
import com.paquier.sistemaVeterinaria.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Empleado>> listar() {
        List<Empleado> empleados= empleadoService.obtenerTodos();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<EmpleadoDto> obtenerPorId(@PathVariable("id") Long id) {
        if(!empleadoService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No se encontro ningun empleado con Id "+id),HttpStatus.NOT_FOUND);
        }
        Empleado empleado = empleadoService.obtenerPorId(id).get();

        EmpleadoDto empleadoResponse = new EmpleadoDto();
        empleadoResponse.setIdEmpleado(empleado.getIdEmpleado());
        empleadoResponse.setNombre(empleado.getNombre());
        empleadoResponse.setApellido(empleado.getApellido());
        empleadoResponse.setRuc(empleado.getRuc());
        empleadoResponse.setCelular(empleado.getCelular());

        return new ResponseEntity<>(empleadoResponse, HttpStatus.OK);
    }

    @GetMapping("/detalle/ruc/{ruc}")
    public ResponseEntity<EmpleadoDto> obtenerPorRuc(@PathVariable("ruc") String ruc) {
        if(!empleadoService.existePorRuc(ruc)){
            return new ResponseEntity(new Mensaje("No se encontro ningun empleado con Ruc "+ruc),HttpStatus.NOT_FOUND);
        }
        Empleado empleado = empleadoService.obtenerPorRuc(ruc).get();

        EmpleadoDto empleadoResponse = new EmpleadoDto();
        empleadoResponse.setIdEmpleado(empleado.getIdEmpleado());
        empleadoResponse.setNombre(empleado.getNombre());
        empleadoResponse.setApellido(empleado.getApellido());
        empleadoResponse.setRuc(empleado.getRuc());
        empleadoResponse.setCelular(empleado.getCelular());

        return new ResponseEntity<>(empleadoResponse, HttpStatus.OK);
    }

    //TODO: validar campos vacíos
    @PostMapping("/crear")
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody EmpleadoDto empleadoDto){
        if(empleadoService.existePorRuc(empleadoDto.getRuc())){
            return new ResponseEntity(new Mensaje("Ya existe un empleado con Ruc "+empleadoDto.getRuc()), HttpStatus.NOT_ACCEPTABLE);
        }
        Empleado empleadoResponse = new Empleado();
        empleadoResponse.setNombre(empleadoDto.getNombre());
        empleadoResponse.setApellido(empleadoDto.getApellido());
        empleadoResponse.setCelular(empleadoDto.getCelular());
        empleadoResponse.setRuc(empleadoDto.getRuc());

        empleadoService.crear(empleadoResponse);

        return new ResponseEntity<>(empleadoResponse, HttpStatus.CREATED);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> crearEmpleado(@PathVariable("id")Long id, @RequestBody EmpleadoDto empleadoDto){

        Empleado empleadoResponse = empleadoService.obtenerPorId(id).get();

        empleadoResponse.setNombre(empleadoDto.getNombre());
        empleadoResponse.setApellido(empleadoDto.getApellido());
        empleadoResponse.setCelular(empleadoDto.getCelular());
        empleadoResponse.setRuc(empleadoDto.getRuc());

        empleadoService.crear(empleadoResponse);

        return new ResponseEntity<>(empleadoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable("id") Long id){
        if(!empleadoService.existePorId(id)){
            return new ResponseEntity<>(new Mensaje("El empleado con id "+ id +" no existe"), HttpStatus.NOT_MODIFIED);
        }
        empleadoService.eliminar(id);
        return new ResponseEntity<>(new Mensaje("Eliminado correctamente"), HttpStatus.OK);
    }


}
