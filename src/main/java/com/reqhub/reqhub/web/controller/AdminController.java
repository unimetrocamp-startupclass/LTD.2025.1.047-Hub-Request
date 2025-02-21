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

    private static final String CODIGO_ACESSO = "NcT127@";
    private static int adminCounter = 0; // Contador simples pra gerar emails únicos

    @GetMapping("/cadastro")
    public String exibirCadastroAdmin() {
        return "atendente/cadastro";
    }

    @PostMapping("/cadastro")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> cadastrarAdmin(@RequestBody Usuario admin) {
        Map<String, Object> resposta = new HashMap<>();

        if (!CODIGO_ACESSO.equals(admin.getCodigo())) {
            resposta.put("sucesso", false);
            resposta.put("mensagem", "Código inválido");
            return ResponseEntity.status(401).body(resposta);
        }

        admin.setTipoUser(TipoUsuario.ADMIN);

        if (admin.getTipoUser() == TipoUsuario.ADMIN) {
            if (admin.getEmail() == null) {
                // Gera um email único usando o nome ou um contador
                String baseEmail = admin.getNome() != null ? admin.getNome().replaceAll("\\s+", "").toLowerCase() : "admin";
                admin.setEmail(baseEmail + adminCounter++ + "@default.com");
            }
            if (admin.getSetor() == null) {
                Setor setorPadrao = setorRepository.findByNome("Admin")
                    .orElseGet(() -> {
                        Setor novoSetor = new Setor();
                        novoSetor.setNome("Admin");
                        return setorRepository.save(novoSetor);
                    });
                admin.setSetor(setorPadrao);
            }
        }

        usuarioService.salvarUsuario(admin);

        resposta.put("sucesso", true);
        resposta.put("mensagem", "Admin cadastrado com sucesso!");
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/admin")
    public String exibirLogin() {
        return "atendente/admin";
    }
}