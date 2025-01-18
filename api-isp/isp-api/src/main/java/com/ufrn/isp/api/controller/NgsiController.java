package com.ufrn.isp.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ngsi")
public class NgsiController {

    @PostMapping("/notify")
    public ResponseEntity<String> handleNotification(@RequestBody Map<String, Object> payload) {
        // Log do payload para depuração
        System.out.println("Recebido payload: " + payload);

        return ResponseEntity.status(HttpStatus.OK).body("Notificação recebida com sucesso");
    }
}
