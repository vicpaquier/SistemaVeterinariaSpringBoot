package com.paquier.sistemaVeterinaria.repository;

import com.paquier.sistemaVeterinaria.entity.Cliente;
import com.paquier.sistemaVeterinaria.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public boolean existsByRuc(String ruc);

    public Optional<Cliente> getByRuc(String ruc);

    public boolean existsByCelular(String celular);
}
