package com.reqhub.reqhub.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
@Entity
@Table(name = "ORDENS")
public class Ordem extends AbstractEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario; // Quem abriu a ordem

    @Column(nullable = false)
    private String descricao; // Comentário ou feedback

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOrdem status; // Agora será inicializado no construtor

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    // Construtor para inicializar os valores padrão
    public Ordem() {
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusOrdem.PENDENTE; // Padrão definido no construtor
    }

    // Getters e Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
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

    public void setStatus(StatusOrdem pendente) {
        this.status = pendente;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
