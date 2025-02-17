package com.reqhub.reqhub.repository;

import com.reqhub.reqhub.domain.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Long> {
    // Métodos customizados podem ser adicionados aqui, se necessário
}
