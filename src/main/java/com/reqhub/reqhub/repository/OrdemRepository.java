package com.reqhub.reqhub.repository;

import com.reqhub.reqhub.domain.Ordem;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Long> {
    List<Ordem> findByUsuarioNome(String nomeUsuario, Sort sort); // Busca ordens por status (ex.: PENDENTE)
}