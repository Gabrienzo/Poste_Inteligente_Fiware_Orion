package com.ufrn.isp.api.service;

import com.ufrn.isp.api.domain.Lighting;
import com.ufrn.isp.api.repository.LightingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LightingService {

    @Autowired
    private LightingRepository lightingRepository;

    public List<Lighting> getAllLightings() {
        return lightingRepository.findAll();
    }

    public Lighting getLightingById(Long id) {
        return lightingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lighting not found"));
    }

    public Lighting createLighting(Lighting lighting) {
        return lightingRepository.save(lighting);
    }

    public Lighting updateLighting(Long id, Lighting updatedLighting) {
        Lighting existingLighting = getLightingById(id);
        existingLighting.setStatus(updatedLighting.getStatus());
        existingLighting.setLocation(updatedLighting.getLocation());
        return lightingRepository.save(existingLighting);
    }

    public void deleteLighting(Long id) {
        lightingRepository.deleteById(id);
    }
}
