package com.nicolas.gestioncandidatos.application.factory;

import com.nicolas.gestioncandidatos.application.dto.TablaMortalidadDTO;
import com.nicolas.gestioncandidatos.domain.TablaMortalidad;

public class TablaMortalidadFactory {

    public static TablaMortalidad fromDTO(TablaMortalidadDTO dto) {
        return TablaMortalidad.builder()
                .edad(dto.getEdad())
                .sexo(dto.getSexo())
                .probabilidadMuerte(dto.getProbabilidadMuerte())
                .build();
    }

    public static TablaMortalidadDTO toDTO(TablaMortalidad entity) {
        return TablaMortalidadDTO.builder()
                .edad(entity.getEdad())
                .sexo(entity.getSexo())
                .probabilidadMuerte(entity.getProbabilidadMuerte())
                .build();
    }
}
