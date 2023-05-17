package com.paquier.sistemaVeterinaria.controller;

import com.paquier.sistemaVeterinaria.dto.MascotaDto;
import com.paquier.sistemaVeterinaria.dto.Mensaje;
import com.paquier.sistemaVeterinaria.entity.Mascota;
import com.paquier.sistemaVeterinaria.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/mascota")
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Mascota>> listar(){
        List<Mascota> mascotas = new ArrayList<>();
        mascotas = mascotaService.obtenerTodos();

        return new ResponseEntity<>(mascotas, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<MascotaDto> obtenerPorId(@PathVariable("id") Long id){
        if(!mascotaService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe la mascota con id "+id), HttpStatus.BAD_REQUEST);
        }

        Mascota mascota = mascotaService.obtenerPorId(id).get();

        MascotaDto responseMascota = new MascotaDto();

        responseMascota.setIdMascota(id);
        responseMascota.setCliente(mascota.getCliente());
        responseMascota.setEspecie(mascota.getEspecie());
        responseMascota.setRaza(mascota.getRaza());
        responseMascota.setColorPelo(mascota.getColorPelo());
        responseMascota.setFechaNacimiento(mascota.getFechaNacimiento());

        return new ResponseEntity<>(responseMascota, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Mascota> crear(@RequestBody MascotaDto mascotaDto){

        Mascota responseMascota = new Mascota();
        responseMascota.setCliente(mascotaDto.getCliente());
        responseMascota.setEspecie(mascotaDto.getEspecie());
        responseMascota.setColorPelo(mascotaDto.getColorPelo());
        responseMascota.setRaza(mascotaDto.getRaza());
        responseMascota.setFechaNacimiento(mascotaDto.getFechaNacimiento());

        mascotaService.crear(responseMascota);

        return new ResponseEntity<>(responseMascota, HttpStatus.CREATED);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Mascota> modificar(@PathVariable("id") Long id, @RequestBody MascotaDto mascotaDto){
        if(!mascotaService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe la mascota con id "+id), HttpStatus.BAD_REQUEST);
        }

        Mascota responseMascota = mascotaService.obtenerPorId(id).get();

        responseMascota.setRaza(mascotaDto.getRaza());
        responseMascota.setCliente(mascotaDto.getCliente());
        responseMascota.setEspecie(mascotaDto.getEspecie());
        responseMascota.setFechaNacimiento(mascotaDto.getFechaNacimiento());
        responseMascota.setColorPelo(mascotaDto.getColorPelo());

        mascotaService.crear(responseMascota);

        return new ResponseEntity<>(responseMascota, HttpStatus.OK);

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable("id")Long id){
        if(!mascotaService.existePorId(id)){
            return new ResponseEntity<>(new Mensaje("No existe la mascota con id "+id), HttpStatus.BAD_REQUEST);
        }

        mascotaService.eliminar(id);

        return new ResponseEntity<>(new Mensaje("Se ha eliminado la mascota con id "+id), HttpStatus.OK);
    }
}
