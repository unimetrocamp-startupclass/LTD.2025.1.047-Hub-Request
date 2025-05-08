package com.reqhub.reqhub.repository;

import com.reqhub.reqhub.domain.Authority;
import com.reqhub.reqhub.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
List<Authority> findByUsuario(Usuario usuario);

Optional<Authority> findByUsuarioAndAuthority(Usuario usuario, String authority);

    // Adicione este método:
    List<Authority> findByUsuarioId(Long usuarioId);

    Optional<Authority> findByUsuarioIdAndAuthority(Long usuarioId, String authority);
}