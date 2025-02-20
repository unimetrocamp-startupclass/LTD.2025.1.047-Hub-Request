package com.reqhub.reqhub.service;

import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioService {

    private static final String CODIGO_ADMIN = "NcT127@"; // Código secreto para criar admin

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void salvarUsuario(Usuario usuario, String codigoAdmin) {
        // Se o usuário for ADMIN, precisa do código correto
        if ("ADMIN".equals(usuario.getTipoUser().toString()) && !CODIGO_ADMIN.equals(codigoAdmin)) {
            throw new RuntimeException("Código de admin inválido!");
        }
        usuarioRepository.save(usuario);
    }

    @Transactional
    public void salvarUsuario(Usuario usuario) {
        // Para usuários normais, salva diretamente
        usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioPorId(Long usuarioId) {
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
        return usuario.orElse(null);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}