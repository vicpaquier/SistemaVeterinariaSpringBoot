package com.paquier.sistemaVeterinaria.controller;

import com.paquier.sistemaVeterinaria.dto.Mensaje;
import com.paquier.sistemaVeterinaria.dto.UsuarioDto;
import com.paquier.sistemaVeterinaria.entity.Usuario;
import com.paquier.sistemaVeterinaria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar(){
        List<Usuario> responseUsuarios = usuarioService.obtenerTodos();

        return new ResponseEntity<>(responseUsuarios, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<UsuarioDto> obtenerPorId(@PathVariable("id")Long id){
        if(!usuarioService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe el usuario con id "+id), HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = usuarioService.obtenerPorId(id).get();

        UsuarioDto responseUsuario = new UsuarioDto();
        responseUsuario.setContra(usuario.getContra());
        responseUsuario.setLogin(usuario.getLogin());
        responseUsuario.setTipo(usuario.getTipo());
        responseUsuario.setIdUsuario(usuario.getIdUsuario());
        responseUsuario.setEmpleado((usuario.getEmpleado()));

        return new ResponseEntity<>(responseUsuario, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Usuario> crear(@RequestBody UsuarioDto usuarioDto){
        if(usuarioService.existePorLogin(usuarioDto.getLogin())){
            return new ResponseEntity(new Mensaje("Ya existe el usuario "+usuarioDto.getLogin()), HttpStatus.BAD_REQUEST);
        }

        System.out.println(usuarioDto);

        Usuario responseUsuario = new Usuario();
        responseUsuario.setLogin(usuarioDto.getLogin());
        responseUsuario.setContra(usuarioDto.getContra());
        responseUsuario.setTipo(usuarioDto.getTipo());
        responseUsuario.setEmpleado(usuarioDto.getEmpleado());

        responseUsuario = usuarioService.crear(responseUsuario);

        return new ResponseEntity<>(responseUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable("id") Long id, @RequestBody UsuarioDto usuarioDto){
        if(!usuarioService.existePorId(id)){
            return new ResponseEntity(new Mensaje("No existe el usuario con id "+id), HttpStatus.BAD_REQUEST);
        }

        Usuario responseUsuario = usuarioService.obtenerPorId(id).get();
        responseUsuario.setLogin(usuarioDto.getLogin());
        responseUsuario.setContra(usuarioDto.getContra());
        responseUsuario.setTipo(usuarioDto.getTipo());

        responseUsuario = usuarioService.crear(responseUsuario);

        return new ResponseEntity<>(responseUsuario, HttpStatus.OK);

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable Long id){
        if(!usuarioService.existePorId(id)){
            return new ResponseEntity<>(new Mensaje("No existe el usuario con id "+id), HttpStatus.BAD_REQUEST);
        }
        usuarioService.eliminar(id);
        return new ResponseEntity<>(new Mensaje("Se ha eliminado el usuario con id "+id), HttpStatus.OK);
    }
}
