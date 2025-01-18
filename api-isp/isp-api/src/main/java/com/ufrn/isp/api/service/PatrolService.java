package com.ufrn.isp.api.service;

import com.ufrn.isp.api.domain.Patrol;
import com.ufrn.isp.api.repository.PatrolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatrolService {

    @Autowired
    private PatrolRepository patrolRepository;

    public List<Patrol> getAllPatrols() {
        return patrolRepository.findAll();
    }

    public Patrol getPatrolById(Long id) {
        return patrolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patrol not found"));
    }

    public Patrol createPatrol(Patrol patrol) {
        return patrolRepository.save(patrol);
    }

    public Patrol updatePatrol(Long id, Patrol updatedPatrol) {
        Patrol existingPatrol = getPatrolById(id);
        existingPatrol.setStatus(updatedPatrol.getStatus());
        existingPatrol.setDataIniciada(updatedPatrol.getDataIniciada());
        existingPatrol.setDataFinalizada(updatedPatrol.getDataFinalizada());
        existingPatrol.setLocalizacao(updatedPatrol.getLocalizacao());
        return patrolRepository.save(existingPatrol);
    }

    public void deletePatrol(Long id) {
        patrolRepository.deleteById(id);
    }
}
