package com.reqhub.reqhub.service;
import com.reqhub.reqhub.domain.Usuario;

import com.reqhub.reqhub.repository.UsuarioRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
  
    public void salvarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}