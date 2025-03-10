package com.reqhub.reqhub.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority extends AbstractEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Column(name = "authority", nullable = false, length = 50)
    private String authority;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Authority() {}

    public Authority(String authority, Usuario usuario) {
        this.authority = authority;
        this.usuario = usuario;
    }

    public String getAuthority() { return authority; } // Deve retornar String
    public void setAuthority(String authority) { this.authority = authority; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}