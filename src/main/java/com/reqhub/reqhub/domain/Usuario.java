package com.reqhub.reqhub.domain;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "USUARIOS")
public class Usuario extends AbstractEntity<Long> {

    @Column(nullable = false, unique = true, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 4, nullable = true)
    private String ramal;

    @ManyToOne
    @JoinColumn(name = "setor_id", nullable = false) 
    private Setor setor;

    @Enumerated(EnumType.STRING) // Salva no banco como texto (ex: "ADMIN" ou "COMUM")
    @Column(nullable = false, length = 10)
    private TipoUsuario tipoUser;
    
    @Column( nullable = true, length = 10 )
    private String senha;  // Apenas para admin
    // Construtor padrão
    public Usuario() {}

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public TipoUsuario getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(TipoUsuario tipoUser) {
        this.tipoUser = tipoUser;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
