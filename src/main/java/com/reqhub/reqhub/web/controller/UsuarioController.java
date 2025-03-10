package com.reqhub.reqhub.web.controller;

import com.reqhub.reqhub.domain.Setor;
import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.repository.SetorRepository;
import com.reqhub.reqhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SetorRepository setorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Injetado aqui

    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("setores", setorRepository.findAll());
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            return ResponseEntity.badRequest().body("Email já existente");
        }
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha())); // Usa o bean injetado
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário cadastrado com sucesso");
    }
}