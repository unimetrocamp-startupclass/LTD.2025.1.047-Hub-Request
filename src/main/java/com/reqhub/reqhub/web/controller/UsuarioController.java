package com.reqhub.reqhub.web.controller;

import com.reqhub.reqhub.domain.Setor;
import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.repository.SetorRepository;
import com.reqhub.reqhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsuarioController {

    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private SetorRepository setorRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("setores", setorRepository.findAll());
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @GetMapping("/homeL")
    public String homeL(Authentication authentication, Model model) {
        if (authentication != null && authentication.isAuthenticated()) {
            String email = authentication.getName(); // Pega o email do usuário autenticado
            Usuario usuario = usuarioRepository.findByEmail(email); // Retorna Usuario diretamente
            if (usuario == null) {
                throw new IllegalStateException("Usuário autenticado não encontrado no banco: " + email);
            }
            String nome = usuario.getNome(); // Pega o nome do usuário
            model.addAttribute("username", nome); // Passa o nome pro modelo
            System.out.println("Usuário logado - Email: " + email + ", Nome: " + nome);
        }
        return "user/homeL"; // Aponta pra templates/user/homeL.html
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario, @RequestParam("setorId") Long setorId) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            return "redirect:/users/cadastrar?error=email";
        }
        Setor setor = setorRepository.findById(setorId)
                .orElseThrow(() -> new IllegalArgumentException("Setor inválido"));
        usuario.setSetor(setor);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
        return "redirect:/auths/login";
    }
}

