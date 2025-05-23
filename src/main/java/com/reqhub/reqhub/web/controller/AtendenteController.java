package com.reqhub.reqhub.web.controller;

import com.reqhub.reqhub.domain.Ordem;
import com.reqhub.reqhub.service.OrdemService;
import com.reqhub.reqhub.web.dto.OrdemAtendenteDTO; // Importe o DTO
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/atendente")
@PreAuthorize("hasRole('ADMIN')")
public class AtendenteController {

    @Autowired
    private OrdemService ordemService;

    @GetMapping("/")
    public String ListOrders(Model model) {
        // listar todas ordens
    }

    @GetMapping("/pendentes")
    public String listarChamadosPendentes(Model model) {
        List<Ordem> ordensPendentes = ordemService.listarOrdensPorStatus("PENDENTE");
        List<OrdemAtendenteDTO> ordensDTO = ordensPendentes.stream()
                .map(ordem -> new OrdemAtendenteDTO(
                        ordem.getId(),
                        ordem.getAssunto(),
                        ordem.getDescricao(),
                        ordem.getUsuario().getNome(), // Supondo que Usuario tem um método getNome()
                        ordem.getStatus().toString()
                ))
                .collect(Collectors.toList());
        model.addAttribute("ordensPendentes", ordensDTO);
        return "atendente/Listar_Chamados";
    }

    @PostMapping("/atender/{id}")
    public String atenderChamado(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            Long atendenteId = ordemService.buscarIdAtendentePorEmail(username);
            if (atendenteId != null) {
                ordemService.atenderOrdem(id, atendenteId);
                return "redirect:/atendente/pendentes";
            } else {
                return "error";
            }
        }
        return "redirect:/auths/login";
    }
}
