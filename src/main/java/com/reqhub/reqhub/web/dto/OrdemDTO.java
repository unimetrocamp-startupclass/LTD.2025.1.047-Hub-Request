package com.reqhub.reqhub.web.dto;

public class OrdemDTO {
	private String assunto;
	private String descricao;
	private String solucao;
	private String atendente;	

	public OrdemDTO(String assunto, String descricao, String solucao, String atendente) {
	this.assunto = assunto;
	this.descricao = descricao;
	this.solucao = solucao;
	this.atendente = atendente;
}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	public String getAtendente() {
		return atendente;
	}

	public void setAtendente(String atendente) {
		this.atendente = atendente;
	}
	
	
	
	
	}