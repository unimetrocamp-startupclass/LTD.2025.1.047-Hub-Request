package com.reqhub.reqhub.service;

import com.reqhub.reqhub.domain.Setor;
import com.reqhub.reqhub.repository.SetorRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;

    // Método para buscar setor pelo nome
    public Setor buscarSetorPorNome(String nome) {
        return setorRepository.findByNome(nome);  // Chama o método no repositório para buscar pelo nome
    }

	public void salvarSetor(Setor setor) {
		// TODO Auto-generated method stub
		
	}
}
