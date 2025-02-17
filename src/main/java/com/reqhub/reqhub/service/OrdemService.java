package com.reqhub.reqhub.service;

import com.reqhub.reqhub.domain.Ordem;
import com.reqhub.reqhub.repository.OrdemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemService {

    @Autowired
    private OrdemRepository ordemRepository;

    public void salvarOrdem(Ordem ordem) {
        ordemRepository.save(ordem);
    }
}
