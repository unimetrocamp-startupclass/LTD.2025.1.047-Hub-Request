package com.reqhub.reqhub.web.controller;

import java.util.List;
import com.reqhub.reqhub.domain.Setor;
import com.reqhub.reqhub.service.SetorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorService setorService;

    // Método para exibir a página de cadastro de setor
    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "setor/cadastro";  // Página para criar um setor
    }

    // Método para exibir a lista de setores cadastrados
    @GetMapping("/listar")
    public String exibirCadastro(Model model) {
        List<Setor> setores = setorService.buscarTodosSetores();  // Buscar todos os setores cadastrados
        model.addAttribute("setores", setores);  // Passar os setores para a view
        return "setor/lista";  // Nome da página onde os setores serão listados
    }

    // Método para cadastrar um novo setor
    @PostMapping("/cadastrar")
    public String cadastrarSetor(@ModelAttribute Setor setor) {
        setorService.salvarSetor(setor);
        return "redirect:/";
    }
}
