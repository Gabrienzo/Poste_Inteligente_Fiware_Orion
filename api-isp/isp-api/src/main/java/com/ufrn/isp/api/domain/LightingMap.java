package com.ufrn.isp.api.domain;


import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
public class LightingMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String localizacao;
    private String status;
    private Timestamp dataMap;


    public LightingMap() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDataMap() {
        return dataMap;
    }

    public void setDataMap(Timestamp dataMap) {
        this.dataMap = dataMap;
    }
}



