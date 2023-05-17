package com.paquier.sistemaVeterinaria.service;

import com.paquier.sistemaVeterinaria.entity.Cliente;
import com.paquier.sistemaVeterinaria.entity.Mascota;
import com.paquier.sistemaVeterinaria.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> obtenerTodos(){
        return mascotaRepository.findAll();
    }

    public void crear(Mascota mascota){
        mascotaRepository.save(mascota);
    }

    public Optional<Mascota> obtenerPorId(Long id){
        return mascotaRepository.findById(id);
    }

    public void eliminar(Long id){
        mascotaRepository.deleteById(id);
    }

    public boolean existePorId(Long id){
        return mascotaRepository.existsById(id);
    }
}
