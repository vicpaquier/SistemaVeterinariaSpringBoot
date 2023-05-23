package com.paquier.sistemaVeterinaria.repository;

import com.paquier.sistemaVeterinaria.entity.Facturacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturacionRepository extends JpaRepository<Facturacion, Long> {
}
