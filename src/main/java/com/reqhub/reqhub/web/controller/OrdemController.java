package com.reqhub.reqhub.web.controller;

import com.reqhub.reqhub.domain.Ordem;
import com.reqhub.reqhub.service.OrdemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("/ordens")
public class OrdemController {

    private static final Logger logger = LoggerFactory.getLogger(OrdemController.class);

    @Autowired
    private OrdemService ordemService;

    @GetMapping("/comentario")
    public String comentario(Model model) {
        logger.info("Acessando página de cadastro de ordem em /ordens/comentario");
        model.addAttribute("ordem", new Ordem());
        return "ordem/comentario"; // Aponta para ordem/comentario.html
    }

    @PostMapping("/comentario")
    public ResponseEntity<String> cadastrarOrdem(@RequestBody OrdemRequest ordemRequest) {
        logger.info("Recebido POST para /ordens/comentario: {}", ordemRequest);
        try {
            Ordem ordem = new Ordem();
            ordem.setAssunto(ordemRequest.getAssunto());
            ordem.setDescricao(ordemRequest.getDescricao());
            ordemService.salvarOrdem(ordem, ordemRequest.getNomeUsuario());
            logger.info("Ordem salva com sucesso, ID: {}", ordem.getId());
            return ResponseEntity.ok(ordem.getId().toString());
        } catch (Exception e) {
            logger.error("Erro ao salvar ordem: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body("Erro ao salvar: " + e.getMessage());
        }
    }

    public static class OrdemRequest {
        private String assunto;
        private String descricao;
        private String nomeUsuario;

        public String getAssunto() { return assunto; }
        public void setAssunto(String assunto) { this.assunto = assunto; }
        public String getDescricao() { return descricao; }
        public void setDescricao(String descricao) { this.descricao = descricao; }
        public String getNomeUsuario() { return nomeUsuario; }
        public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }
        @Override
        public String toString() {
            return "OrdemRequest{assunto='" + assunto + "', descricao='" + descricao + "', nomeUsuario='" + nomeUsuario + "'}";
        }
    }
}