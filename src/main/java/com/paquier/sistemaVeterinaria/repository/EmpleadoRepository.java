package com.paquier.sistemaVeterinaria.repository;

import com.paquier.sistemaVeterinaria.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    public boolean existsByRuc(String ruc);

    public Optional<Empleado> getByRuc(String ruc);
}
