package com.reqhub.reqhub.web.controller;

import com.reqhub.reqhub.domain.Authority;
import com.reqhub.reqhub.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authorities")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Authority>> listarAuthorities() {
        return ResponseEntity.ok(authorityService.listarAuthorities());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/atribuir")
    public ResponseEntity<String> atribuirPapel(@RequestParam Long usuarioId, @RequestParam String role) {
        try {
            authorityService.atribuirPapel(usuarioId, role);
            return ResponseEntity.ok("Papel atribuído com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/remover")
    public ResponseEntity<String> removerPapel(@RequestParam Long usuarioId, @RequestParam String role) {
        try {
            authorityService.removerPapel(usuarioId, role);
            return ResponseEntity.ok("Papel removido com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}