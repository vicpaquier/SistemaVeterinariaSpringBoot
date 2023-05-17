package com.paquier.sistemaVeterinaria.service;

import com.paquier.sistemaVeterinaria.entity.Cliente;
import com.paquier.sistemaVeterinaria.entity.Empleado;
import com.paquier.sistemaVeterinaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos(){
        return clienteRepository.findAll();
    }

    public void crear(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public Optional<Cliente> obtenerPorId(Long id){
        return clienteRepository.findById(id);
    }

    public Optional<Cliente> obtenerPorRuc(String ruc){
        return clienteRepository.getByRuc(ruc);
    }

    public void eliminar(Long id){
        clienteRepository.deleteById(id);
    }

    public boolean existePorRuc(String ruc){
        return clienteRepository.existsByRuc(ruc);
    }

    public boolean existePorId(Long id){
        return clienteRepository.existsById(id);
    }

    public boolean existePorCelular(String celular){
        return clienteRepository.existsByCelular(celular);
    }

}
