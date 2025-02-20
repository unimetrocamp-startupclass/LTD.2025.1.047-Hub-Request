package com.reqhub.reqhub.web.controller;

import com.reqhub.reqhub.domain.Setor;
import com.reqhub.reqhub.domain.TipoUsuario;
import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.service.SetorService;
import com.reqhub.reqhub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SetorService setorService;

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        List<Setor> setores = setorService.buscarTodosSetores();
        model.addAttribute("setores", setores);
        model.addAttribute("usuario", new Usuario());
        return "user/cadastro"; // Ajuste para "user/cadastrar" se o HTML for "cadastrar.html"
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getSetor() != null && usuario.getSetor().getId() != null) {
            // Garante que tipoUser seja definido (não nulo)
            if (usuario.getTipoUser() == null) {
                usuario.setTipoUser(TipoUsuario.COMUM);
            }
            usuarioService.salvarUsuario(usuario); // JPA mapeia o setor pelo ID
            return "redirect:/ordens/comentario";
        }
        return "redirect:/users/cadastrar";
    }
}