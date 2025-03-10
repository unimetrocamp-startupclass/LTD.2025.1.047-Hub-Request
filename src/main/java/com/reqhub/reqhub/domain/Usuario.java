package com.reqhub.reqhub.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USUARIOS")
public class Usuario extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, unique = true, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 4, nullable = true)
    private String ramal;

    @Column(nullable = true, length = 10)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "setor_id", nullable = false)
    private Setor setor;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Authority> authorities = new ArrayList<>();

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRamal() { return ramal; }
    public void setRamal(String ramal) { this.ramal = ramal; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public Setor getSetor() { return setor; }
    public void setSetor(Setor setor) { this.setor = setor; }
    public List<Authority> getAuthorities() { return authorities; }
    public void setAuthorities(List<Authority> authorities) { this.authorities = authorities; }
}