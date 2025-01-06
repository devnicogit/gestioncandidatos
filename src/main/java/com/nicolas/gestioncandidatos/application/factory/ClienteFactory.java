package com.nicolas.gestioncandidatos.application.factory;

import com.nicolas.gestioncandidatos.application.dto.ClienteDTO;
import com.nicolas.gestioncandidatos.domain.Cliente;

public class ClienteFactory {

    private static final int ESPERANZA_VIDA = 75;

    public static Cliente fromDTO(ClienteDTO clienteDTO) {
        return Cliente.builder()
                .nombre(clienteDTO.getNombre())
                .apellido(clienteDTO.getApellido())
                .edad(clienteDTO.getEdad())
                .fechaNacimiento(clienteDTO.getFechaNacimiento())
                .build();
    }

    public static ClienteDTO toDTO(Cliente cliente) {
        return ClienteDTO.builder()
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .edad(cliente.getEdad())
                .fechaNacimiento(cliente.getFechaNacimiento())
                .fechaEstimadaFallecimiento(cliente.getFechaNacimiento().plusYears(ESPERANZA_VIDA))
                .build();
    }
}
