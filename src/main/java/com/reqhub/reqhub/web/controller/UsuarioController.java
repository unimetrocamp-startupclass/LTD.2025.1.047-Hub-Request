package com.reqhub.reqhub.web.controller;

import com.reqhub.reqhub.domain.Setor;
import com.reqhub.reqhub.domain.TipoUsuario;
import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.service.SetorService;
import com.reqhub.reqhub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SetorService setorService;

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "user/cadastro";  // Página de cadastro de usuário
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@RequestParam("nome") String nome, @RequestParam("email") String email,
                                   @RequestParam("ramal") String ramal, @RequestParam("setorNome") String setorNome,
                                   @RequestParam("tipoUser") String tipoUser) {
        Setor setor = (Setor) setorService.buscarSetorPorNome(setorNome);  // Busca o setor pelo nome
        if (setor != null) {
            // Converte a String para o Enum TipoUsuario
            TipoUsuario tipo = TipoUsuario.valueOf(tipoUser.toUpperCase());  // Converte para o enum

            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setRamal(ramal);
            usuario.setSetor(setor);
            usuario.setTipoUser(tipo);  // Agora setando o tipoUser como o tipo enum
            usuarioService.salvarUsuario(usuario);  // Salva o usuário usando o service
            return "redirect:/feedback/cadastrar";  // Redireciona para cadastro de feedback
        }
        return "redirect:/users/cadastrar";  // Se o setor não for encontrado, volta para a página de cadastro
    }
}
