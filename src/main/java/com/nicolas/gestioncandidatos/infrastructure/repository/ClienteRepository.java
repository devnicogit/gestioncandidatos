package com.nicolas.gestioncandidatos.infrastructure.repository;

import com.nicolas.gestioncandidatos.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

    @Query("SELECT AVG(c.edad) FROM Cliente c")
    Double calcularPromedioEdad();

    @Query("SELECT STDDEV(c.edad) FROM Cliente c")
    Double calcularDesviacionEstandarEdad();
}
