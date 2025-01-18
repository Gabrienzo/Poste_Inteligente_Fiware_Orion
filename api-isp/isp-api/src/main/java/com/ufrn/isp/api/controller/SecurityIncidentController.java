package com.ufrn.isp.api.controller;

import com.ufrn.isp.api.domain.SecurityIncident;
import com.ufrn.isp.api.service.SecurityIncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/security-incidents")
public class SecurityIncidentController {

    @Autowired
    private SecurityIncidentService securityIncidentService;

    @GetMapping
    public List<SecurityIncident> getAllIncidents() {
        return securityIncidentService.getAllIncidents();
    }

    @GetMapping("/{id}")
    public SecurityIncident getIncidentById(@PathVariable Long id) {
        return securityIncidentService.getIncidentById(id);
    }

    @PostMapping
    public SecurityIncident createIncident(@RequestBody SecurityIncident incident) {
        return securityIncidentService.createIncident(incident);
    }

    @PutMapping("/{id}")
    public SecurityIncident updateIncident(@PathVariable Long id, @RequestBody SecurityIncident incident) {
        return securityIncidentService.updateIncident(id, incident);
    }

    @DeleteMapping("/{id}")
    public void deleteIncident(@PathVariable Long id) {
        securityIncidentService.deleteIncident(id);
    }
}
