package com.paquier.sistemaVeterinaria.service;

import com.paquier.sistemaVeterinaria.entity.DetalleCobro;
import com.paquier.sistemaVeterinaria.repository.DetalleCobroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCobroService {
    @Autowired
    DetalleCobroRepository detalleCobroRepository;
    public List<DetalleCobro> list(){
        return this.detalleCobroRepository.findAll();
    }

    public DetalleCobro crear(DetalleCobro cobro){
        return this.detalleCobroRepository.save(cobro);
    }

    public Optional<DetalleCobro> obtenerPorId(Long id){
        return this.detalleCobroRepository.findById(id);
    }

    public void eliminar(Long id){
        this.detalleCobroRepository.deleteById(id);
    }
}
