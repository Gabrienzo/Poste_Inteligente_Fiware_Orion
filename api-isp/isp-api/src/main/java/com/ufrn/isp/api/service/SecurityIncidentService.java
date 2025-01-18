package com.ufrn.isp.api.service;

import com.ufrn.isp.api.domain.SecurityIncident;
import com.ufrn.isp.api.repository.SecurityIncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecurityIncidentService {

    @Autowired
    private SecurityIncidentRepository securityIncidentRepository;

    public List<SecurityIncident> getAllIncidents() {
        return securityIncidentRepository.findAll();
    }

    public SecurityIncident getIncidentById(Long id) {
        return securityIncidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Security Incident not found"));
    }

    public SecurityIncident createIncident(SecurityIncident incident) {
        return securityIncidentRepository.save(incident);
    }

    public SecurityIncident updateIncident(Long id, SecurityIncident updatedIncident) {
        SecurityIncident existingIncident = getIncidentById(id);
        existingIncident.setDescricao(updatedIncident.getDescricao());
        existingIncident.setStatus(updatedIncident.getStatus());
        existingIncident.setLocalizacao(updatedIncident.getLocalizacao());
        return securityIncidentRepository.save(existingIncident);
    }

    public void deleteIncident(Long id) {
        securityIncidentRepository.deleteById(id);
    }
}
