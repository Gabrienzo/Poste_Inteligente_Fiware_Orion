package com.ufrn.isp.api.controller;

import com.ufrn.isp.api.domain.Patrol;
import com.ufrn.isp.api.service.PatrolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrols")
public class PatrolController {

    @Autowired
    private PatrolService patrolService;

    @GetMapping
    public List<Patrol> getAllPatrols() {
        return patrolService.getAllPatrols();
    }

    @GetMapping("/{id}")
    public Patrol getPatrolById(@PathVariable Long id) {
        return patrolService.getPatrolById(id);
    }

    @PostMapping
    public Patrol createPatrol(@RequestBody Patrol patrol) {
        return patrolService.createPatrol(patrol);
    }

    @PutMapping("/{id}")
    public Patrol updatePatrol(@PathVariable Long id, @RequestBody Patrol patrol) {
        return patrolService.updatePatrol(id, patrol);
    }

    @DeleteMapping("/{id}")
    public void deletePatrol(@PathVariable Long id) {
        patrolService.deletePatrol(id);
    }
}
