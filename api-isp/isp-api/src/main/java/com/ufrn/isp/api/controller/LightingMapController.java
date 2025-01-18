package com.ufrn.isp.api.controller;

import com.ufrn.isp.api.domain.LightingMap;
import com.ufrn.isp.api.service.LightingMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lighting-map")
public class LightingMapController {

    @Autowired
    private LightingMapService lightingMapService;

    @GetMapping
    public List<LightingMap> getAllMappings() {
        return lightingMapService.getAllMappings();
    }

    @GetMapping("/{id}")
    public LightingMap getMappingById(@PathVariable Long id) {
        return lightingMapService.getMappingById(id);
    }

    @PostMapping
    public LightingMap createMapping(@RequestBody LightingMap mapping) {
        return lightingMapService.createMapping(mapping);
    }

    @PutMapping("/{id}")
    public LightingMap updateMapping(@PathVariable Long id, @RequestBody LightingMap mapping) {
        return lightingMapService.updateMapping(id, mapping);
    }

    @DeleteMapping("/{id}")
    public void deleteMapping(@PathVariable Long id) {
        lightingMapService.deleteMapping(id);
    }
}
