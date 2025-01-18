package com.ufrn.isp.api.controller;

import com.ufrn.isp.api.domain.Camera;
import com.ufrn.isp.api.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cameras")
public class CameraController {

    @Autowired
    private CameraService cameraService;

    @GetMapping
    public List<Camera> getAllCameras() {
        return cameraService.getAllCameras();
    }

    @GetMapping("/{id}")
    public Camera getCameraById(@PathVariable Long id) {
        return cameraService.getCameraById(id);
    }

    @PostMapping
    public Camera createCamera(@RequestBody Camera camera) {
        return cameraService.createCamera(camera);
    }

    @PutMapping("/{id}")
    public Camera updateCamera(@PathVariable Long id, @RequestBody Camera camera) {
        return cameraService.updateCamera(id, camera);
    }

    @DeleteMapping("/{id}")
    public void deleteCamera(@PathVariable Long id) {
        cameraService.deleteCamera(id);
    }
}
