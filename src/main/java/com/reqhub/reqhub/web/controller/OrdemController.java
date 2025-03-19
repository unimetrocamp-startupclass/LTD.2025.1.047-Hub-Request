package com.reqhub.reqhub.web.controller;

import com.reqhub.reqhub.domain.Ordem;
import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.repository.UsuarioRepository;
import com.reqhub.reqhub.service.OrdemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/ordens")
public class OrdemController {

    private static final Logger logger = LoggerFactory.getLogger(OrdemController.class);

    @Autowired private OrdemService ordemService;
    @Autowired private UsuarioRepository usuarioRepository;

    @GetMapping("/comentario")
    public String comentario(Model model) {
        logger.info("Acessando página de cadastro de ordem em /ordens/comentario");
        model.addAttribute("ordem", new Ordem());
        return "ordem/comentario"; // Aponta pra templates/ordens/comentario.html
    }

    @PostMapping("/comentario")
    @ResponseBody
    public ResponseEntity<String> cadastrarOrdem(@RequestBody OrdemRequest ordemRequest, Authentication authentication) {
        logger.info("Recebido POST para /ordens/comentario: {}", ordemRequest);
        try {
            if (authentication == null || !authentication.isAuthenticated()) {
                logger.error("Nenhum usuário autenticado encontrado");
                throw new IllegalStateException("Usuário não autenticado");
            }

            String email = authentication.getName();
            logger.info("Email do usuário autenticado: {}", email);

            Usuario usuario = usuarioRepository.findByEmail(email);
            if (usuario == null) {
                logger.error("Usuário não encontrado no banco para o email: {}", email);
                throw new IllegalStateException("Usuário autenticado não encontrado: " + email);
            }
            logger.info("Usuário encontrado: {}", usuario.getNome());

            Ordem ordem = new Ordem();
            ordem.setUsuario(usuario);
            ordem.setAssunto(ordemRequest.getAssunto());
            ordem.setDescricao(ordemRequest.getDescricao());
            logger.info("Ordem criada: assunto={}, descricao={}", ordem.getAssunto(), ordem.getDescricao());

            ordemService.salvarOrdem(ordem);
            logger.info("Ordem salva com sucesso, ID: {}", ordem.getId());
            return ResponseEntity.ok(ordem.getId().toString());
        } catch (Exception e) {
            logger.error("Erro ao salvar ordem: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body("Erro ao salvar: " + e.getMessage());
        }
    }

    @GetMapping("/pesquisa")
    public String redirecionarPesquisa() {
        return "ordem/pesquisa";
    }

    @PostMapping("/pesquisa")
    @ResponseBody
    public ResponseEntity<List<Ordem>> pesquisarOrdens(@RequestBody PesquisaRequest pesquisaRequest) {
        logger.info("Recebido POST para /ordens/pesquisa: {}", pesquisaRequest);
        
        List<Ordem> ordens;
        if (pesquisaRequest.getId() != null) {
            Ordem ordem = ordemService.findById(pesquisaRequest.getId());
            ordens = ordem != null ? Collections.singletonList(ordem) : Collections.emptyList();
        } else if (pesquisaRequest.getNome() != null && !pesquisaRequest.getNome().trim().isEmpty()) {
            ordens = ordemService.buscarOrdensPorNomeUsuario(pesquisaRequest.getNome());
        } else {
            ordens = ordemService.listarTodasOrdens();
        }
        
        return ResponseEntity.ok(ordens);
    }

    // Classe interna OrdemRequest
    public static class OrdemRequest {
        private String assunto;
        private String descricao;

        public String getAssunto() { return assunto; }
        public void setAssunto(String assunto) { this.assunto = assunto; }
        public String getDescricao() { return descricao; }
        public void setDescricao(String descricao) { this.descricao = descricao; }
        @Override
        public String toString() {
            return "OrdemRequest{assunto='" + assunto + "', descricao='" + descricao + "'}";
        }
    }

    // Classe interna PesquisaRequest
    public static class PesquisaRequest {
        private Long id;
        private String nome;

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }
        @Override
        public String toString() {
            return "PesquisaRequest{id=" + id + ", nome='" + nome + "'}";
        }
    }
}