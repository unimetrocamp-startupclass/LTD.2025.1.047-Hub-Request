package com.reqhub.reqhub.service;

import com.reqhub.reqhub.domain.Authority;
import com.reqhub.reqhub.domain.Ordem;
import com.reqhub.reqhub.domain.StatusOrdem;
import com.reqhub.reqhub.domain.Usuario;
import com.reqhub.reqhub.repository.AuthorityRepository;
import com.reqhub.reqhub.repository.OrdemRepository;
import com.reqhub.reqhub.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemService {

    @Autowired private OrdemRepository ordemRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private AuthorityRepository authorityRepository;

    public void salvarOrdem(Ordem ordem) {
        ordemRepository.save(ordem);
    }

    public Ordem findById(Long id) {
        return ordemRepository.findById(id).orElse(null);
    }

    public List<Ordem> buscarOrdensPorNomeUsuario(String nomeUsuario) {
        return ordemRepository.findByUsuarioNome(nomeUsuario, Sort.by(Sort.Direction.DESC, "dataCriacao"));
    }

    public List<Ordem> buscarOrdensPorUsuario(Usuario usuario) {
        return ordemRepository.findByUsuarioNome(usuario.getNome(), Sort.by(Sort.Direction.DESC, "dataCriacao"));
    }

    public List<Ordem> listarTodasOrdens() {
        return ordemRepository.findAll(Sort.by(Sort.Direction.DESC, "dataCriacao"));
    }
    public List<Ordem> buscarTodasOrdens() {
        return ordemRepository.findAll();
    }

    public void excluirOrdem(Long id) {
        ordemRepository.deleteById(id);
    }
    public List<Ordem> listarOrdensPorStatus(String status) {
        try {
            StatusOrdem statusOrdem = StatusOrdem.valueOf(status.toUpperCase()); // Converte para maiúsculo para evitar erros
            return ordemRepository.findByStatus(statusOrdem);
        } catch (IllegalArgumentException e) {
            // Lidar com o caso em que o status fornecido não é um valor válido do enum
            return Collections.emptyList(); // Retorna uma lista vazia ou lança uma exceção, dependendo da sua lógica
        }
    }

    @Transactional
    public void atenderOrdem(Long ordemId, Long atendenteId) {
        Ordem ordem = ordemRepository.findById(ordemId)
                .orElseThrow(() -> new IllegalArgumentException("Chamado não encontrado com ID: " + ordemId));
        // Buscar a Authority do atendente pelo ID do usuário (assumindo que atendenteId é o ID do usuário admin)
        Authority atendente = authorityRepository.findByUsuarioIdAndAuthority(atendenteId, "ROLE_ADMIN") // Ajuste a role se necessário
                .orElseThrow(() -> new IllegalArgumentException("Atendente com ID: " + atendenteId + " não encontrado ou não é um administrador."));
        ordem.setAtendente(atendente);
        ordem.setStatus(StatusOrdem.PENDENTE); // Use a sua enum StatusOrdem
        ordemRepository.save(ordem);
    }

    public Long buscarIdAtendentePorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .map(usuario -> usuario.getId())
                .orElse(null);
    }
}