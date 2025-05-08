package com.reqhub.reqhub.web.dto;

public class OrdemAtendenteDTO {
    private Long id;
    private String assunto;
    private String descricao;
    private String nomeUsuario; // Nome do usuário que criou a ordem
    private String status;

    public OrdemAtendenteDTO() {
    }

    public OrdemAtendenteDTO(Long id, String assunto, String descricao, String nomeUsuario, String status) {
        this.id = id;
        this.assunto = assunto;
        this.descricao = descricao;
        this.nomeUsuario = nomeUsuario;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
