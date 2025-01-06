package com.nicolas.gestioncandidatos.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TablaMortalidadDTO {

    private int edad;
    private String sexo; // "M" o "F"
    private double probabilidadMuerte;
}
