package com.paquier.sistemaVeterinaria.service;

import com.paquier.sistemaVeterinaria.entity.Agendamiento;
import com.paquier.sistemaVeterinaria.repository.AgendamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamientoService {
    @Autowired
    private AgendamientoRepository agendamientoRepository;

    public List<Agendamiento> obtenerTodos(){
        return agendamientoRepository.findAll();
    }

    public void crear(Agendamiento agendamiento){
        agendamientoRepository.save(agendamiento);
    }

    public Optional<Agendamiento> obtenerPorId(Long id){
        return agendamientoRepository.findById(id);
    }

    public void eliminar(Long id){
        agendamientoRepository.deleteById(id);
    }

    public boolean existePorId(Long id){
        return agendamientoRepository.existsById(id);
    }
}
