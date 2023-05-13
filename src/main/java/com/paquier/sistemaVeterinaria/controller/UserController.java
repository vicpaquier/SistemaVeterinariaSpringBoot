package com.paquier.sistemaVeterinaria.controller;

import com.paquier.sistemaVeterinaria.entity.Usuario;
import com.paquier.sistemaVeterinaria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/crear")
    public ResponseEntity<Usuario> crearUsuario(Usuario usuario){
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }


}
