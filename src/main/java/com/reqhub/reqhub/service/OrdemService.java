package com.reqhub.reqhub.service;

import com.reqhub.reqhub.domain.Ordem;
import com.reqhub.reqhub.domain.StatusOrdem;
import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.repository.OrdemRepository;
import com.reqhub.reqhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrdemService {

    @Autowired
    private OrdemRepository ordemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void salvarOrdem(Ordem ordem, String nomeUsuario) {
        Usuario usuario = usuarioRepository.findByNome(nomeUsuario)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o nome: " + nomeUsuario));
        ordem.setUsuario(usuario);
        ordemRepository.save(ordem);
    }

    public Ordem findById(Long id) {
        return ordemRepository.findById(id).orElse(null);
    }

    public List<Ordem> listarTodasOrdens() {
        return ordemRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public List<Ordem> buscarOrdensPorNomeUsuario(String nomeUsuario) {
 
    	return ordemRepository.findByUsuarioNome(nomeUsuario, Sort.by(Sort.Direction.ASC, "id"));
    }
    
    }
    