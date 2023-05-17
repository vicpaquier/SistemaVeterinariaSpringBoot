package com.paquier.sistemaVeterinaria.repository;

import com.paquier.sistemaVeterinaria.entity.EstadoAgendamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoAgendamientoRepository extends JpaRepository<EstadoAgendamiento, Long> {
}
