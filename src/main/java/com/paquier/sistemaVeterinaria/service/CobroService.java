package com.paquier.sistemaVeterinaria.service;

import com.paquier.sistemaVeterinaria.entity.Cobro;
import com.paquier.sistemaVeterinaria.repository.CobroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CobroService {
    @Autowired
    CobroRepository cobroRepository;

    public List<Cobro> list(){
        return this.cobroRepository.findAll();
    }

    public Cobro crear(Cobro cobro){
        return this.cobroRepository.save(cobro);
    }

    public Optional<Cobro> obtenerPorId(Long id){
        return this.cobroRepository.findById(id);
    }

    public void eliminar(Long id){
        this.cobroRepository.deleteById(id);
    }

    public boolean existePorId(Long id){ return this.cobroRepository.existsById(id);}
}
