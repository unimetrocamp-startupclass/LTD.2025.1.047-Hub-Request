package com.reqhub.reqhub.service;

import com.reqhub.reqhub.domain.Ordem;
import com.reqhub.reqhub.repository.OrdemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemService {

    @Autowired private OrdemRepository ordemRepository;

    public void salvarOrdem(Ordem ordem) {
        ordemRepository.save(ordem);
    }

    public Ordem findById(Long id) {
        return ordemRepository.findById(id).orElse(null);
    }

    public List<Ordem> buscarOrdensPorNomeUsuario(String nomeUsuario) {
        return ordemRepository.findByUsuarioNome(nomeUsuario, Sort.by(Sort.Direction.DESC, "dataCriacao"));
    }

    public List<Ordem> listarTodasOrdens() {
        return ordemRepository.findAll(Sort.by(Sort.Direction.DESC, "dataCriacao"));
    }
}