package com.paquier.sistemaVeterinaria.service;

import com.paquier.sistemaVeterinaria.entity.Empleado;
import com.paquier.sistemaVeterinaria.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> obtenerTodos(){
        return empleadoRepository.findAll();
    }

    public void crear(Empleado empleado){
        empleadoRepository.save(empleado);
    }

    public Optional<Empleado> obtenerPorId(Long id){
        return empleadoRepository.findById(id);
    }

    public Optional<Empleado> obtenerPorRuc(String ruc){
        return empleadoRepository.getByRuc(ruc);
    }

    public void eliminar(Long id){
        empleadoRepository.deleteById(id);
    }

    public boolean existePorRuc(String ruc){
        return empleadoRepository.existsByRuc(ruc);
    }

    public boolean existePorId(Long id){
        return empleadoRepository.existsById(id);
    }

}
