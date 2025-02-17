package com.reqhub.reqhub.web.controller;

import com.reqhub.reqhub.domain.Setor;
import com.reqhub.reqhub.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @GetMapping("/cadastrar") 
    public String cadastrar() {
        return "setor/cadastro";  // Página para criar um setor
    }

    @PostMapping("/cadastrar")
    public String cadastrarSetor(@RequestParam("nome") String nome) {
        Setor setor = new Setor();
        setor.setNome(nome);
        setorService.salvarSetor(setor);  // Salva o setor usando o service
        return "redirect:/users/cadastrar";  // Redireciona para o cadastro de usuário
    }
}
