package com.ufrn.isp.api.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Patrol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private Timestamp dataIniciada;
    private Timestamp dataFinalizada;
    private Long usuarioId;
    private String localizacao;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDataIniciada() {
        return dataIniciada;
    }

    public void setDataIniciada(Timestamp dataIniciada) {
        this.dataIniciada = dataIniciada;
    }

    public Timestamp getDataFinalizada() {
        return dataFinalizada;
    }

    public void setDataFinalizada(Timestamp dataFinalizada) {
        this.dataFinalizada = dataFinalizada;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
