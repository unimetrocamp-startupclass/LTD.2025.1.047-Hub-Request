package com.reqhub.reqhub.web.controller;

import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.repository.SetorRepository;
import com.reqhub.reqhub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("auths")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SetorRepository setorRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "auth/login";
    }
    
    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("setores", setorRepository.findAll()); // Usa a instância injetada
        return "auth/cadastrar";
    }

    @PostMapping("/cadastrar")
    @ResponseBody
    public String cadastrarUsuario(@RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario); // Usa a instância injetada
        return "Usuário cadastrado com sucesso!";
    }
}