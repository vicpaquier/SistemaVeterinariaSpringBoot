package com.paquier.sistemaVeterinaria.service;

import com.paquier.sistemaVeterinaria.entity.DetalleFacturacion;
import com.paquier.sistemaVeterinaria.entity.Facturacion;
import com.paquier.sistemaVeterinaria.repository.DetalleFacturacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturacionService {
    @Autowired
    private DetalleFacturacionRepository detalleFacturacionRepository;

    public List<DetalleFacturacion> obtenerTodos(){ return   detalleFacturacionRepository.findAll();}

    public void crear(DetalleFacturacion detalleFacturacion){
        detalleFacturacionRepository.save(detalleFacturacion);
    }

    public Optional<DetalleFacturacion> obtenerPorId(Long id){
        return detalleFacturacionRepository.findById(id);
    }

    public void eliminar(Long id){
        detalleFacturacionRepository.deleteById(id);
    }

    public boolean existePorId(Long id){
        return detalleFacturacionRepository.existsById(id);
    }
}
