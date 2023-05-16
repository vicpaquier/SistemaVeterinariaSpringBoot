package com.paquier.sistemaVeterinaria.service;

import com.paquier.sistemaVeterinaria.entity.Usuario;
import com.paquier.sistemaVeterinaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    public Usuario crearUsuario(Usuario usuario) {
        return userRepository.save(usuario);
    }
}
