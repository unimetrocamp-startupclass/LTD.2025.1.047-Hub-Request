package com.reqhub.reqhub.domain;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table (name = "Users")
public class User extends AbstractEntity<Long> {

	@Column(nullable = false, unique = true, length = 100)
	private String nome;
	
	@Column(nullable = false, unique = true, length = 100)
	private String email;
	
	@Column(length = 4)
	private String ramal;
	 @ManyToOne
	  @JoinColumn(name = "setor_id", nullable = false) // Nome correto da coluna no banco
	  private Setor setor;
	 
	 @Column(nullable = false,length = 100)
	 private String tipoUser;

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

	public String getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}
	 
	


	
}
