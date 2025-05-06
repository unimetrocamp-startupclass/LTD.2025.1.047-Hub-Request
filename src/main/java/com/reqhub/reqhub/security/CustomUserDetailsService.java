package com.reqhub.reqhub.security;

import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.repository.AuthorityRepository; // Adicione a injeção do AuthorityRepository
import com.reqhub.reqhub.repository.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository; // Injete o AuthorityRepository

    public CustomUserDetailsService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Tentando carregar usuário com email: " + email);
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            System.out.println("Usuário não encontrado para email: " + email);
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        System.out.println("Usuário encontrado: " + usuario.getEmail() + ", senha: " + usuario.getSenha());

        List<GrantedAuthority> authorities = authorityRepository.findByUsuario(usuario).stream()
                .map(auth -> new SimpleGrantedAuthority(auth.getAuthority()))
                .collect(Collectors.toList());

        if (authorities.isEmpty()) {
            System.out.println("Nenhuma autoridade encontrada para " + usuario.getEmail() + ", atribuindo ROLE_USER padrão.");
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            System.out.println("Autoridades carregadas para " + usuario.getEmail() + ": " + authorities);
        }

        return new User(usuario.getEmail(), usuario.getSenha(), authorities);
    }
}