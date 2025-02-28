package com.reqhub.reqhub.web.controller;

import com.reqhub.reqhub.domain.Setor;
import com.reqhub.reqhub.domain.TipoUsuario;
import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.repository.SetorRepository;
import com.reqhub.reqhub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SetorRepository setorRepository;

    private static int adminCounter = 0;

    @GetMapping("/cadastro")
    public String exibirCadastroAdmin() {
        return "atendente/cadastro";
    }

    @PostMapping("/cadastro")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> cadastrarAdmin(@RequestBody Usuario admin) {
        Map<String, Object> resposta = new HashMap<>();

        // Removida a validação do código de acesso
        // Definindo o setor primeiro
        if (admin.getSetor() == null) {
            Setor setorPadrao = setorRepository.findByNome("Admin")
                .orElseGet(() -> {
                    Setor novoSetor = new Setor();
                    novoSetor.setNome("Admin");
                    return setorRepository.save(novoSetor);
                });
            admin.setSetor(setorPadrao); // Chama setSetor aqui primeiro
        }

        // Garante que tipoUser seja ADMIN, sobrescrevendo qualquer lógica do setSetor
        admin.setTipoUser(TipoUsuario.ADMIN);

        if (admin.getEmail() == null) {
            String baseEmail = admin.getNome() != null ? admin.getNome().replaceAll("\\s+", "").toLowerCase() : "admin";
            admin.setEmail(baseEmail + adminCounter++ + "@default.com");
        }

        usuarioService.salvarUsuario(admin);

        resposta.put("sucesso", true);
        resposta.put("mensagem", "Admin cadastrado com sucesso!");
        return ResponseEntity.ok(resposta);
    }
}