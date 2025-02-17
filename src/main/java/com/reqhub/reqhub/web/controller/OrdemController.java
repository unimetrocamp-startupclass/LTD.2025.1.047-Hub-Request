package com.reqhub.reqhub.web.controller;

import com.reqhub.reqhub.domain.Ordem;
import com.reqhub.reqhub.domain.StatusOrdem;
import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.service.OrdemService;
import com.reqhub.reqhub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ordens")
public class OrdemController {

    @Autowired
    private OrdemService ordemService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/comentario")
	public String comentario() {
		return "ordem/comentario";
	}
	
	@GetMapping("/buscar")
	public String buscar() {
		return "ordem/buscar";
	}
    @PostMapping("/cadastrar")
    public String cadastrarOrdem(@RequestParam("usuarioId") Long usuarioId, @RequestParam("descricao") String descricao) {
        // Buscar o usuário pelo ID
        Usuario usuario = usuarioService.buscarUsuarioPorId(usuarioId);
        if (usuario != null) {
            Ordem ordem = new Ordem();
            ordem.setUsuario(usuario);  // Associando o usuário
            ordem.setDescricao(descricao);  // A descrição do feedback
            ordem.setStatus(StatusOrdem.PENDENTE);  // Status padrão como "PENDENTE"
            ordemService.salvarOrdem(ordem);  // Salva a ordem
            return "redirect:/feedback/listar";  // Redireciona para página de listar feedbacks
        }
        return "redirect:/feedback/cadastrar";  // Caso o usuário não exista, volta para o cadastro
    }
}
