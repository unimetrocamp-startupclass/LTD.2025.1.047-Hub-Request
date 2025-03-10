package com.reqhub.reqhub.service;

import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void salvarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado.");
        }
        usuarioRepository.save(usuario);
    }
}