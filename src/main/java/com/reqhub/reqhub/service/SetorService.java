package com.reqhub.reqhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.reqhub.reqhub.domain.Setor;
import com.reqhub.reqhub.repository.SetorRepository;

@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;

    // Método para buscar setor pelo nome
    public Optional<Setor> buscarSetorPorNome(String nome) {
        return setorRepository.findByNome(nome);  // Chama o método no repositório para buscar pelo nome
    }

    // Método para salvar setor
    public void salvarSetor(Setor setor) {
        setorRepository.save(setor);  // Salva o setor no banco
    }

    // Método para buscar todos os setores cadastrados
    public List<Setor> buscarTodosSetores() {
        return setorRepository.findAll();  // Retorna todos os setores cadastrados
    }
}
