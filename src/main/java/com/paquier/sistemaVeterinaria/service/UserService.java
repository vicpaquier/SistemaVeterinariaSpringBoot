package com.paquier.sistemaVeterinaria.service;

import com.paquier.sistemaVeterinaria.entity.Usuario;
import com.paquier.sistemaVeterinaria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Usuario crearUsuario(Usuario usuario) {
        return userRepository.save(usuario);
    }
}
