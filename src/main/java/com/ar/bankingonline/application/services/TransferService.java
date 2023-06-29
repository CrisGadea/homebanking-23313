package com.ar.bankingonline.application.services;

import com.ar.bankingonline.infrastructure.repositories.TransfersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    private TransfersRepository repository;

    public TransferService(TransfersRepository repository){
        this.repository = repository;
    }

    //TODO: Completar el CRUD del Service

}
