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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private TipoUsuario tipoUser;

    @Column(nullable = true, length = 10)
    private String senha;

    public Usuario() {}

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRamal() { return ramal; }
    public void setRamal(String ramal) { this.ramal = ramal; }

    public Setor getSetor() { return setor; }
    public void setSetor(Setor setor) { 
        this.setor = setor; 
        if ("TI".equalsIgnoreCase(setor.getNome())) { 
            this.tipoUser = TipoUsuario.ADMIN;
        }
    }

    public TipoUsuario getTipoUser() { return tipoUser; }
    public void setTipoUser(TipoUsuario tipoUser) { this.tipoUser = tipoUser; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}