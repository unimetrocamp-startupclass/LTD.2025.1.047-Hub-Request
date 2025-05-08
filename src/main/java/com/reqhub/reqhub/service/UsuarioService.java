package com.reqhub.reqhub.service;

import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Método para salvar o usuário
    public void salvarUsuario(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha())); // Criptografando a senha antes de salvar
        usuarioRepository.save(usuario);
    }

    // Novo método de autenticação
    public boolean autenticarUsuario(String email, String senha) {
        System.out.println("Email recebido: " + email);
        System.out.println("Senha recebida: " + senha);
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email); // Obtém o Optional<Usuario>
        if (!usuarioOptional.isPresent()) { // Verifica se o Optional está vazio
            System.out.println("Usuário não encontrado para o email: " + email);
            return false;
        }
        Usuario usuario = usuarioOptional.get(); // Obtém o Usuario do Optional
        System.out.println("Senha no banco: " + usuario.getSenha());
        boolean matches = passwordEncoder.matches(senha, usuario.getSenha());
        System.out.println("Senhas coincidem: " + matches);
        return matches;
    }
}
