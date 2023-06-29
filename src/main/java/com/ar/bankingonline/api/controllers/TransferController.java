package com.ar.bankingonline.api.controllers;

import com.ar.bankingonline.application.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransferController {

    private TransferService service;

    @Autowired
    public TransferController(TransferService service){
        this.service = service;
    }

    //TODO: Completar el CRUD del Controller
}
