package com.paquier.sistemaVeterinaria.service;

import com.paquier.sistemaVeterinaria.entity.Empleado;
import com.paquier.sistemaVeterinaria.entity.Servicio;
import com.paquier.sistemaVeterinaria.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {
    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> obtenerTodos(){
        return servicioRepository.findAll();
    }

    public void crear(Servicio servicio){
        servicioRepository.save(servicio);
    }

    public Optional<Servicio> obtenerPorId(Long id){
        return servicioRepository.findById(id);
    }


    public void eliminar(Long id){
        servicioRepository.deleteById(id);
    }

    public boolean existePorId(Long id){
        return servicioRepository.existsById(id);
    }
}
