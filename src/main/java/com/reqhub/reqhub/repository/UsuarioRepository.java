package com.reqhub.reqhub.repository;

import com.reqhub.reqhub.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByNome(String nome);
    List<Usuario> findBySetorId(Long setorId);
    boolean existsByEmail(String email);
}