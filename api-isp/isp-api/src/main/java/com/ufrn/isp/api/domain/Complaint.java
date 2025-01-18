package com.ufrn.isp.api.domain;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId; // Referência ao usuário que fez a reclamação
    private String descricao; // Detalhamento da reclamação
    private String status; // Status da reclamação (pendente, resolvida)
    private Timestamp dataCriacao; // Data de criação da reclamação
    private Timestamp dataResolucao; // Data de resolução, se aplicável

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

    public Timestamp getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Timestamp dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Timestamp getDataResolucao() {
        return dataResolucao;
    }

    public void setDataResolucao(Timestamp dataResolucao) {
        this.dataResolucao = dataResolucao;
    }
}
