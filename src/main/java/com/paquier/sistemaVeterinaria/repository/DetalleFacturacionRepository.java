package com.paquier.sistemaVeterinaria.repository;

import com.paquier.sistemaVeterinaria.entity.DetalleFacturacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturacionRepository extends JpaRepository<DetalleFacturacion, Long> {
}
