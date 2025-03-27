package com.reqhub.reqhub.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
@Entity
@Table(name = "ORDENS")
public class Ordem extends AbstractEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String assunto;

    @Column(nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOrdem status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column
    private String solucao;

    @ManyToOne
    @JoinColumn(name = "atendente_id")
    private Authority atendente; // Alterado de Usuario para Authority

    public Ordem() {
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusOrdem.PENDENTE;
    }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public String getAssunto() { return assunto; }
    public void setAssunto(String assunto) { this.assunto = assunto; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public StatusOrdem getStatus() { return status; }
    public void setStatus(StatusOrdem status) { this.status = status; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public String getSolucao() { return solucao; }
    public void setSolucao(String solucao) { this.solucao = solucao; }
    public Authority getAtendente() { return atendente; }
    public void setAtendente(Authority atendente) { this.atendente = atendente; }
}