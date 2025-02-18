package com.reqhub.reqhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reqhub.reqhub.domain.Setor;
import java.util.Optional;

public interface SetorRepository extends JpaRepository<Setor, Long> {
    Optional<Setor> findByNome(String nome);  // Alteração para Optional
}
