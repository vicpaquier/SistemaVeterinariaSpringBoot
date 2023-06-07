package com.paquier.sistemaVeterinaria.repository;

import com.paquier.sistemaVeterinaria.entity.Cobro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CobroRepository extends JpaRepository<Cobro, Long> {
}
