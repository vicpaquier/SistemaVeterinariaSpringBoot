package com.paquier.sistemaVeterinaria.controller;

import com.paquier.sistemaVeterinaria.dto.CobroDto;
import com.paquier.sistemaVeterinaria.dto.Mensaje;
import com.paquier.sistemaVeterinaria.entity.Cobro;
import com.paquier.sistemaVeterinaria.service.CobroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/cobro")
public class CobroController {

    @Autowired
    CobroService cobroService;
    @GetMapping("/listar")
    public ResponseEntity<List<Cobro>> listar(){
        List<Cobro> cobro = cobroService.list();
        return new ResponseEntity<>(cobro, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<CobroDto> obtenerPorId(@PathVariable("id") long id){
        if(!cobroService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe el cobro con id "+id), HttpStatus.BAD_REQUEST);
        }

        Cobro cobro = cobroService.obtenerPorId(id).get();

        CobroDto responseCobro = new CobroDto();
        responseCobro.setIdCobro(cobro.getIdCobro());
        responseCobro.setFecha(cobro.getFecha());
        responseCobro.setUsuario(cobro.getUsuario());

        return new ResponseEntity<>(responseCobro, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Cobro> crear(@RequestBody CobroDto cobroDto){
        Cobro responseCobro = new Cobro();

        responseCobro.setFecha(cobroDto.getFecha());
        responseCobro.setUsuario(cobroDto.getUsuario());
        responseCobro.setIdCobro(cobroDto.getIdCobro());

        cobroService.crear(responseCobro);

        return new ResponseEntity<>(responseCobro, HttpStatus.OK);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Cobro> modificar(@PathVariable("id") long id, @RequestBody CobroDto cobroDto){
        if(!cobroService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe el cobro con id "+id), HttpStatus.BAD_REQUEST);
        }
        Cobro responseCobro = cobroService.obtenerPorId(id).get();
        responseCobro.setFecha(cobroDto.getFecha());
        responseCobro.setUsuario(cobroDto.getUsuario());
        responseCobro.setIdCobro(cobroDto.getIdCobro());

        cobroService.crear(responseCobro);
        return new ResponseEntity<>(responseCobro, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable("id") long id){
        if(!cobroService.existePorId(id)){
            return new ResponseEntity<>(new Mensaje("No existe el cobro con id "+id), HttpStatus.BAD_REQUEST);
        }
        cobroService.eliminar(id);
        return new ResponseEntity<>(new Mensaje("Se ha eliminado el cobro con id "+id), HttpStatus.OK);
    }
}
