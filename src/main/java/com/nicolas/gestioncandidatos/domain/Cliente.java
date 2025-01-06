package com.nicolas.gestioncandidatos.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private int edad;
    private LocalDate fechaNacimiento;
    private String sexo; // "M" o "F"
    private String estadoSalud; // Ejemplo: "Excelente", "Bueno", "Regular", "Malo"
    private String habitosVida; // Ejemplo: "Fumador", "Sedentario", etc.
}
