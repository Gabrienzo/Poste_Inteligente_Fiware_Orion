package com.ufrn.isp.api.domain;


import jakarta.persistence.*;

@Entity
public class Lighting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // Tipo de lâmpada (ex: LED, Incandescente)
    private String location; // Localização da lâmpada (ex: Rua X, Bairro Y)
    private String status; // Status da lâmpada (ex: "acesa", "apagada", "com falha")
    private Integer lifeSpan; // Vida útil da lâmpada em horas
    private Boolean isActive; // Se a lâmpada está ativa ou não (pode ser ligada/desligada)

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(Integer lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
