package com.reqhub.reqhub.domain;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "SETORES")
public class Setor extends AbstractEntity<Long> {

    @Column(name = "nome", nullable = false, unique = true, length = 60)
    private String nome;

    // Construtor padrão
    public Setor() {}

    // Construtor com parâmetro
    public Setor(String nome) {
        this.nome = nome.trim(); // Removendo espaços extras
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = (nome != null) ? nome.trim() : null;
    }

    @Override
    public String toString() {
        return "Setor{id=" + getId() + ", nome='" + nome + "'}";
    }
}