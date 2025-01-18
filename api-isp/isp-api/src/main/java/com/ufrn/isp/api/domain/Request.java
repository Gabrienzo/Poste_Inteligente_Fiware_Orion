package com.ufrn.isp.api.domain;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId; // Referência ao usuário que fez a solicitação
    private String tipoSolicitacao; // Tipo da solicitação (ex: troca de lâmpada, patrulhamento, segurança)
    private String descricao; // Detalhamento da solicitação
    private String status; // Status da solicitação (pendente, em andamento, resolvido)
    private Timestamp dataCriacao; // Data de criação da solicitação
    private Timestamp dataResolucao; // Data de resolução, se aplicável
    private String localizacao; // Local da solicitação

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

    public String getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(String tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
