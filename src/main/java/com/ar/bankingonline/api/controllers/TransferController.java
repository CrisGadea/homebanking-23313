package com.ar.bankingonline.api.controllers;

import com.ar.bankingonline.api.dtos.TransferDto;
import com.ar.bankingonline.application.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransferController {

    private TransferService service;

    @Autowired
    public TransferController(TransferService service){
        this.service = service;
    }

    //TODO: Completar el CRUD del Controller

    @GetMapping(value = "/transfers")
    public ResponseEntity<List<TransferDto>> getTransfers(){
        List<TransferDto> transfers = service.getTransfers();
        return ResponseEntity.status(200).body(transfers);
    }

    @GetMapping(value = "/transfers/{id}")
    public ResponseEntity<TransferDto> getTransferById(@PathVariable Long id){
        TransferDto transfer = service.getTransferById(id);
        return ResponseEntity.status(200).body(transfer);
    }

    @PostMapping(value = "/transfers")
    public ResponseEntity<TransferDto> createTransfer(@RequestBody TransferDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTransfer(dto));
    }

    @PutMapping(value = "/transfers/{id}")
    public ResponseEntity<TransferDto> updateTransfer(@PathVariable Long id, @RequestBody TransferDto transfer){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateTransfer(id, transfer));
    }

    @DeleteMapping(value = "/transfers/{id}")
    public ResponseEntity<String> deleteTransfer(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteTransfer(id));
    }
}
