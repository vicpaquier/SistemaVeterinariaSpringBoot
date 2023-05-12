package com.paquier.sistemaVeterinaria.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/prueba")
    public ResponseEntity<?> mensaje(){
        return ResponseEntity.ok("Hola mundo");
    }
}
