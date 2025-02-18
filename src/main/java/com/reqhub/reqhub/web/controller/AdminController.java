package com.reqhub.reqhub.web.controller;

import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.domain.TipoUsuario;
import com.reqhub.reqhub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admins")  // Endereço para todas as rotas relacionadas ao admin
public class AdminController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String exibirCadastroAdmin() {
        return "atendente/cadastro";  // Página de cadastro do admin
    }

    @PostMapping("/cadastro")
    public String cadastrarAdmin(@RequestParam("nome") String nome,
                                 @RequestParam("senha") String senha,
                                 @RequestParam("codigo") String codigo) {
        // Verificação do código
        if (!codigo.equals("NcT127@")) {
            return "redirect:/admin/cadastrar?erro=CodigoInvalido";
        }

        // Criação do usuário admin
        Usuario admin = new Usuario();
        admin.setNome(nome);
        admin.setSenha(senha);
        admin.setTipoUser(TipoUsuario.ADMIN);

        // Salvar o admin
        usuarioService.salvarUsuario(admin);
        return "redirect:/admin";  // Redireciona para a página de login
    }

    @GetMapping("/admin")
    public String exibirLogin() {
        return "atendente/admin";  // Página de login do admin
    }
}
