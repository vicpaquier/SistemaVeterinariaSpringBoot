package com.paquier.sistemaVeterinaria.service;

import com.paquier.sistemaVeterinaria.entity.EstadoAgendamiento;
import com.paquier.sistemaVeterinaria.repository.EstadoAgendamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoAgendamientoService {
    @Autowired
    private EstadoAgendamientoRepository estadoAgendamientoRepository;

    public List<EstadoAgendamiento> obtenerTodos(){
        return estadoAgendamientoRepository.findAll();
    }

    public void crear(EstadoAgendamiento estadoAgendamiento){
        estadoAgendamientoRepository.save(estadoAgendamiento);
    }

    public Optional<EstadoAgendamiento> obtenerPorId(Long id){
        return estadoAgendamientoRepository.findById(id);
    }

    public void eliminar(Long id){
        estadoAgendamientoRepository.deleteById(id);
    }

    public boolean existePorId(Long id){
        return estadoAgendamientoRepository.existsById(id);
    }

}
