package com.paquier.sistemaVeterinaria.repository;

import com.paquier.sistemaVeterinaria.entity.DetalleCobro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCobroRepository extends JpaRepository<DetalleCobro, Long> {
}
