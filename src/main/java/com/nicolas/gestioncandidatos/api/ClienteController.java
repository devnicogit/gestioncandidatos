package com.nicolas.gestioncandidatos.api;


import com.nicolas.gestioncandidatos.application.dto.ClienteDTO;
import com.nicolas.gestioncandidatos.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> registrarCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO registrado = clienteService.registrarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(registrado);
    }
    
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientesConEsperanzaDeVida() {
        return ResponseEntity.ok(clienteService.listarClientesConEsperanzaDeVida());
    }

    @GetMapping("/metricas")
    public ResponseEntity<Map<String, Double>> obtenerMetricas() {
        Double promedio = clienteService.obtenerPromedioEdad();
        Double desviacion = clienteService.obtenerDesviacionEstandarEdad();
        return ResponseEntity.ok(Map.of(
                "promedioEdad", promedio,
                "desviacionEstandarEdad", desviacion
        ));
    }
}
