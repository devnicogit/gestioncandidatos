package com.nicolas.gestioncandidatos.application.service.impl;


import com.nicolas.gestioncandidatos.application.dto.ClienteDTO;
import com.nicolas.gestioncandidatos.application.service.ClienteService;
import com.nicolas.gestioncandidatos.domain.Cliente;
import com.nicolas.gestioncandidatos.domain.TablaMortalidad;
import com.nicolas.gestioncandidatos.infrastructure.repository.ClienteRepository;
import com.nicolas.gestioncandidatos.infrastructure.repository.TablaMortalidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final TablaMortalidadRepository tablaMortalidadRepository;


    @Override
    public ClienteDTO registrarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = Cliente.builder()
                .nombre(clienteDTO.getNombre())
                .apellido(clienteDTO.getApellido())
                .edad(clienteDTO.getEdad())
                .fechaNacimiento(clienteDTO.getFechaNacimiento())
                .sexo(clienteDTO.getSexo())
                .build();
        cliente = clienteRepository.save(cliente);
        return ClienteDTO.builder()
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .edad(cliente.getEdad())
                .fechaNacimiento(cliente.getFechaNacimiento())
                .sexo(cliente.getSexo())
                .build();
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        return clienteRepository.findAll().stream()
                .map(cliente -> ClienteDTO.builder()
                        .nombre(cliente.getNombre())
                        .apellido(cliente.getApellido())
                        .edad(cliente.getEdad())
                        .fechaNacimiento(cliente.getFechaNacimiento())
                        .sexo(cliente.getSexo())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<ClienteDTO> listarClientesConEsperanzaDeVida() {
        return clienteRepository.findAll().stream()
                .map(cliente -> ClienteDTO.builder()
                        .nombre(cliente.getNombre())
                        .apellido(cliente.getApellido())
                        .edad(cliente.getEdad())
                        .fechaNacimiento(cliente.getFechaNacimiento())
                        .fechaEstimadaFallecimiento(calcularFechaEstimadaFallecimiento(cliente))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public Double obtenerPromedioEdad() {
        return clienteRepository.calcularPromedioEdad();
    }

    @Override
    public Double obtenerDesviacionEstandarEdad() {
        return clienteRepository.calcularDesviacionEstandarEdad();
    }

    private LocalDate calcularFechaEstimadaFallecimiento(Cliente cliente) {
        double esperanzaRestante = calcularEsperanzaDeVida(cliente);
        return cliente.getFechaNacimiento().plusYears((long) esperanzaRestante);
    }

    private double calcularEsperanzaDeVida(Cliente cliente) {
        int edadActual = cliente.getEdad();
        double esperanzaRestante = 0;

        while (edadActual < 120) { // Edad máxima en teoría
            TablaMortalidad mortalidad = tablaMortalidadRepository.findByEdadAndSexo(edadActual, cliente.getSexo());
            if (mortalidad == null) break;
            esperanzaRestante += (1 - mortalidad.getProbabilidadMuerte());
            edadActual++;
        }

        return esperanzaRestante;
    }

}
