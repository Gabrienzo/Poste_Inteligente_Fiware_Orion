package com.ufrn.isp.api.domain;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class SecurityIncident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId; // Referência ao usuário que fez o relato
    private String descricao; // Detalhamento do incidente
    private String status; // Status do incidente (pendente, resolvido)
    private String localizacao; // Local onde ocorreu o incidente
    private Timestamp dataOcorrencia; // Data e hora do incidente

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Timestamp getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Timestamp dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }
}
