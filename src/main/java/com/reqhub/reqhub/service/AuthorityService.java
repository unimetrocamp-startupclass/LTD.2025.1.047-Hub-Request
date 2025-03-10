package com.reqhub.reqhub.service;

import com.reqhub.reqhub.domain.Authority;
import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.repository.AuthorityRepository;
import com.reqhub.reqhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Authority> listarAuthorities() {
        return authorityRepository.findAll();
    }

    @Transactional
    public void atribuirPapel(Long usuarioId, String role) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
        Authority authority = new Authority(role.toUpperCase(), usuario);
        authorityRepository.save(authority);
    }

    @Transactional
    public void removerPapel(Long usuarioId, String role) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
        Authority authority = authorityRepository.findByUsuarioAndAuthority(usuario, role.toUpperCase())
                .orElseThrow(() -> new IllegalArgumentException("Papel não encontrado para este usuário."));
        authorityRepository.delete(authority);
    }
}