package com.paquier.sistemaVeterinaria.service;

import com.paquier.sistemaVeterinaria.entity.Facturacion;
import com.paquier.sistemaVeterinaria.entity.Mascota;
import com.paquier.sistemaVeterinaria.repository.FacturacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturacionService {
    @Autowired
    private FacturacionRepository facturacionRepository;

    public List<Facturacion> obtenerTodos(){ return   facturacionRepository.findAll();}

    public void crear(Facturacion facturacion){
        facturacionRepository.save(facturacion);
    }

    public Optional<Facturacion> obtenerPorId(Long id){
        return facturacionRepository.findById(id);
    }

    public void eliminar(Long id){
        facturacionRepository.deleteById(id);
    }

    public boolean existePorId(Long id){
        return facturacionRepository.existsById(id);
    }
}
