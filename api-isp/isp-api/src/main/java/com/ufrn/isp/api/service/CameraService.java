package com.ufrn.isp.api.service;

import com.ufrn.isp.api.domain.Camera;
import com.ufrn.isp.api.repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraService {

    @Autowired
    private CameraRepository cameraRepository;

    public List<Camera> getAllCameras() {
        return cameraRepository.findAll();
    }

    public Camera getCameraById(Long id) {
        return cameraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Camera not found"));
    }

    public Camera createCamera(Camera camera) {
        return cameraRepository.save(camera);
    }

    public Camera updateCamera(Long id, Camera updatedCamera) {
        Camera existingCamera = getCameraById(id);
        existingCamera.setTipo(updatedCamera.getTipo());
        existingCamera.setStatus(updatedCamera.getStatus());
        existingCamera.setLocalizacao(updatedCamera.getLocalizacao());
        return cameraRepository.save(existingCamera);
    }

    public void deleteCamera(Long id) {
        cameraRepository.deleteById(id);
    }
}
