package com.nicolas.gestioncandidatos.application.service;

import com.nicolas.gestioncandidatos.application.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    ClienteDTO registrarCliente(ClienteDTO clienteDTO);

    List<ClienteDTO> listarClientes();

    List<ClienteDTO> listarClientesConEsperanzaDeVida();

    Double obtenerPromedioEdad();

    Double obtenerDesviacionEstandarEdad();
}
