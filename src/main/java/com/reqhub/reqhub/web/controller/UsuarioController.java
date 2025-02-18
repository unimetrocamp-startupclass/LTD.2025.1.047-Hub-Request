package com.reqhub.reqhub.web.controller;

import com.reqhub.reqhub.domain.Setor;
import com.reqhub.reqhub.domain.TipoUsuario;
import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.service.SetorService;
import com.reqhub.reqhub.service.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SetorService setorService;

    // Página de cadastro de usuário
    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        // Carregar todos os setores do banco de dados
        List<Setor> setores = setorService.buscarTodosSetores();
        model.addAttribute("setores", setores); // Adicionar a lista de setores ao modelo
        return "user/cadastro";  // A página de cadastro de usuário
    }

    // Cadastro de usuário
    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@RequestBody Usuario usuario) {
        // Busca o setor pelo nome do usuário
        Setor setor = usuario.getSetor(); // O setor já está no objeto Usuario

        if (setor != null) {
            // Salva o usuário
            usuarioService.salvarUsuario(usuario);  
            return "redirect:/feedback/cadastrar";  // Redireciona para a página de cadastro de feedback
        }

        return "redirect:/users/cadastrar";  // Caso o setor não exista, redireciona para a página de cadastro
    }
}
