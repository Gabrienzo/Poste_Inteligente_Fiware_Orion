package com.ufrn.isp.api.service;

import com.ufrn.isp.api.domain.LightingMap;
import com.ufrn.isp.api.repository.LightingMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LightingMapService {

    @Autowired
    private LightingMapRepository lightingMapRepository;

    public List<LightingMap> getAllMappings() {
        return lightingMapRepository.findAll();
    }

    public LightingMap getMappingById(Long id) {
        return lightingMapRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lighting Map not found"));
    }

    public LightingMap createMapping(LightingMap mapping) {
        return lightingMapRepository.save(mapping);
    }

    public LightingMap updateMapping(Long id, LightingMap updatedMapping) {
        LightingMap existingMapping = getMappingById(id);
        existingMapping.setStatus(updatedMapping.getStatus());
        existingMapping.setLocalizacao(updatedMapping.getLocalizacao());
        return lightingMapRepository.save(existingMapping);
    }

    public void deleteMapping(Long id) {
        lightingMapRepository.deleteById(id);
    }
}
