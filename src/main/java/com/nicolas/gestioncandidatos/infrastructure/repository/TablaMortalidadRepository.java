package com.nicolas.gestioncandidatos.infrastructure.repository;

import com.nicolas.gestioncandidatos.domain.TablaMortalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablaMortalidadRepository extends JpaRepository<TablaMortalidad, Long> {
    TablaMortalidad findByEdadAndSexo(int edad, String sexo);
}
