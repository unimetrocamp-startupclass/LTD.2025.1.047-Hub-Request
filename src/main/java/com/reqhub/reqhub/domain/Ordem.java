package com.reqhub.reqhub.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
@Entity
@Table(name = "ORDENS")
public class Ordem extends AbstractEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario; // Quem abriu a ordem

    @Column(nullable = false)
    private String descricao; // Comentário ou feedback

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOrdem status = StatusOrdem.PENDENTE; // Padrão: PENDENTE

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now(); // Data automática

    // Getters e Setters
    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusOrdem getStatus() {
        return status;
    }

    public void setStatus(StatusOrdem status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
