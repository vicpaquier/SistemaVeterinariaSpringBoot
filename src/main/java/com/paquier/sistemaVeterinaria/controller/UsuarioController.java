package com.paquier.sistemaVeterinaria.controller;

import com.paquier.sistemaVeterinaria.entity.Usuario;
import com.paquier.sistemaVeterinaria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @PostMapping("/crear")
    public ResponseEntity<Usuario> crearUsuario(Usuario usuario){
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }


}
