package com.ufrn.isp.api.controller;

import com.ufrn.isp.api.domain.Lighting;
import com.ufrn.isp.api.repository.LightingRepository;
import com.ufrn.isp.api.service.LightingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class LightingController {

    LightingRepository lightingRepository;

    @PostMapping("/update")
    public ResponseEntity<String> updateLightStatus(@RequestBody Map<String, Object> payload) {
        try {
            String entityId = (String) payload.get("id");

            // Busca ou cria uma nova instância de Lighting
            Optional<Lighting> existingLighting = lightingRepository.findById(Long.valueOf(entityId));
            Lighting lighting = existingLighting.orElse(new Lighting());
            lighting.setId(Long.valueOf(entityId));

            // Atualiza os atributos
            Map<String, Object> attributes = (Map<String, Object>) payload.get("attributes");
            Map<String, Object> statusAttribute = (Map<String, Object>) attributes.get("status");
            lighting.setStatus((String) statusAttribute.get("value"));

            // Adicional: atualize outros campos conforme necessário
            if (attributes.containsKey("location")) {
                lighting.setLocation((String) ((Map<String, Object>) attributes.get("location")).get("value"));
            }

            // Salva no banco
            lightingRepository.save(lighting);
            return ResponseEntity.ok("Status atualizado com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao processar a atualização: " + e.getMessage());
        }
    }

    // Endpoint para consultar o status de todas as luzes
    @GetMapping("/status")
    public ResponseEntity<Iterable<Lighting>> getLightStatus() {
        return ResponseEntity.ok(lightingRepository.findAll());
    }
}
