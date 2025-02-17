package com.reqhub.reqhub.service;

import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service  // <-- ESSENCIAL para que o Spring gerencie essa classe!
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void salvarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);  // Salva o usuário no banco
    }

    public Usuario buscarUsuarioPorId(Long usuarioId) {
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
        return usuario.orElse(null);  // Retorna o usuário ou null se não encontrar
    }
}
