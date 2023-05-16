package com.paquier.sistemaVeterinaria.repository;

import com.paquier.sistemaVeterinaria.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
