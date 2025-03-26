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

import java.util.List;

@Controller
@RequestMapping("/ordens")
public class OrdemController {

    private static final Logger logger = LoggerFactory.getLogger(OrdemController.class);

    @Autowired private OrdemService ordemService;
    @Autowired private UsuarioRepository usuarioRepository;

    @GetMapping("/comentario")
    public String comentario(Model model) {
        logger.info("Acessando página de cadastro de ordem em /ordem/comentario");
        model.addAttribute("ordem", new Ordem());
        return "ordem/comentario";
    }

    @PostMapping("/comentario")
    @ResponseBody
    public ResponseEntity<String> cadastrarOrdem(@RequestBody OrdemRequest ordemRequest, Authentication authentication) {
        logger.info("Recebido POST para /ordem/comentario: {}", ordemRequest);
        try {
            String email = authentication.getName();
            Usuario usuario = usuarioRepository.findByEmail(email);
            if (usuario == null) throw new IllegalStateException("Usuário autenticado não encontrado: " + email);

            Ordem ordem = new Ordem();
            ordem.setUsuario(usuario);
            ordem.setAssunto(ordemRequest.getAssunto());
            ordem.setDescricao(ordemRequest.getDescricao());
            ordemService.salvarOrdem(ordem);
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

    @GetMapping("/minhas-ordens")
    @ResponseBody
    public ResponseEntity<List<Ordem>> listarOrdensUsuario(Authentication authentication) {
        logger.info("Listando ordens do usuário autenticado");
        try {
            String email = authentication.getName();
            Usuario usuario = usuarioRepository.findByEmail(email);
            if (usuario == null) throw new IllegalStateException("Usuário autenticado não encontrado: " + email);
            List<Ordem> ordens = ordemService.buscarOrdensPorUsuario(usuario);
            return ResponseEntity.ok(ordens);
        } catch (Exception e) {
            logger.error("Erro ao listar ordens: {}", e.getMessage(), e);
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/editar/{id}")
    public String editarOrdem(@PathVariable Long id, Model model, Authentication authentication) {
        logger.info("Acessando página de edição da ordem: {}", id);
        try {
            String email = authentication.getName();
            Usuario usuario = usuarioRepository.findByEmail(email);
            if (usuario == null) throw new IllegalStateException("Usuário autenticado não encontrado: " + email);

            Ordem ordem = ordemService.findById(id);
            if (!ordem.getUsuario().getId().equals(usuario.getId())) {
                throw new IllegalStateException("Você não tem permissão para editar esta ordem");
            }
            model.addAttribute("ordem", ordem);
            return "ordem/editar";
        } catch (Exception e) {
            logger.error("Erro ao carregar ordem para edição: {}", e.getMessage(), e);
            return "ordem/pesquisa";
        }
    }

    @PostMapping("/editar")
    @ResponseBody
    public ResponseEntity<String> salvarEdicaoOrdem(@RequestBody OrdemRequest ordemRequest, @RequestParam Long id, Authentication authentication) {
        logger.info("Salvando edição da ordem: {}", id);
        try {
            String email = authentication.getName();
            Usuario usuario = usuarioRepository.findByEmail(email);
            if (usuario == null) throw new IllegalStateException("Usuário autenticado não encontrado: " + email);

            Ordem ordem = ordemService.findById(id);
            if (!ordem.getUsuario().getId().equals(usuario.getId())) {
                return ResponseEntity.status(403).body("Você não tem permissão para editar esta ordem");
            }

            ordem.setAssunto(ordemRequest.getAssunto());
            ordem.setDescricao(ordemRequest.getDescricao());
            ordemService.salvarOrdem(ordem);
            return ResponseEntity.ok("Ordem editada com sucesso");
        } catch (Exception e) {
            logger.error("Erro ao salvar edição: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body("Erro ao editar: " + e.getMessage());
        }
    }

    @GetMapping("/excluir/{id}")
    public String confirmarExclusao(@PathVariable Long id, Model model, Authentication authentication) {
        logger.info("Acessando página de confirmação de exclusão da ordem: {}", id);
        try {
            String email = authentication.getName();
            Usuario usuario = usuarioRepository.findByEmail(email);
            if (usuario == null) throw new IllegalStateException("Usuário autenticado não encontrado: " + email);

            Ordem ordem = ordemService.findById(id);
            if (!ordem.getUsuario().getId().equals(usuario.getId())) {
                throw new IllegalStateException("Você não tem permissão para excluir esta ordem");
            }
            model.addAttribute("ordem", ordem);
            return "ordem/excluir";
        } catch (Exception e) {
            logger.error("Erro ao carregar ordem para exclusão: {}", e.getMessage(), e);
            return "ordem/excluir";
        }
    }

    @PostMapping("/excluir")
    @ResponseBody
    public ResponseEntity<String> excluirOrdem(@RequestBody OrdemIdRequest ordemId, Authentication authentication) {
        logger.info("Excluindo ordem: {}", ordemId.getId());
        try {
            String email = authentication.getName();
            Usuario usuario = usuarioRepository.findByEmail(email);
            if (usuario == null) throw new IllegalStateException("Usuário autenticado não encontrado: " + email);

            Ordem ordem = ordemService.findById(ordemId.getId());
            if (!ordem.getUsuario().getId().equals(usuario.getId())) {
                return ResponseEntity.status(403).body("Você não tem permissão para excluir esta ordem");
            }

            ordemService.excluirOrdem(ordemId.getId());
            return ResponseEntity.ok("Ordem excluída com sucesso");
        } catch (Exception e) {
            logger.error("Erro ao excluir ordem: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body("Erro ao excluir: " + e.getMessage());
        }
    }

    public static class OrdemRequest {
        private String assunto;
        private String descricao;
        public String getAssunto() { return assunto; }
        public void setAssunto(String assunto) { this.assunto = assunto; }
        public String getDescricao() { return descricao; }
        public void setDescricao(String descricao) { this.descricao = descricao; }
        @Override
        public String toString() { return "OrdemRequest{assunto='" + assunto + "', descricao='" + descricao + "'}"; }
    }

    public static class OrdemIdRequest {
        private Long id;
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
    }
}