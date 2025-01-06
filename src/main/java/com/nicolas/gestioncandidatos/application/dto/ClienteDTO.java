package com.nicolas.gestioncandidatos.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {

    private String nombre;
    private String apellido;
    private int edad;
    private LocalDate fechaNacimiento;
    private String sexo;
    private LocalDate fechaEstimadaFallecimiento;
}
