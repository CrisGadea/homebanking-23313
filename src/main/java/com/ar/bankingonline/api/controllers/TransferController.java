package com.ar.bankingonline.api.controllers;

import com.ar.bankingonline.api.dtos.TransferDto;
import com.ar.bankingonline.application.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransferController {

    private TransferService service;

    @Autowired
    public TransferController(TransferService service){
        this.service = service;
    }

    @GetMapping(value = "/transfers")
    public ResponseEntity<List<TransferDto>> getTransfers(){
        List<TransferDto> transfers = service.getTransfers();
        return ResponseEntity.status(HttpStatus.OK).body(transfers);
    }

    @GetMapping(value = "/transfers/{id}")
    public ResponseEntity<TransferDto> getTransferById(@PathVariable Long id){
        TransferDto transfer = service.getTransferById(id);
        return ResponseEntity.status(HttpStatus.OK).body(transfer);
    }


    @PostMapping(value = "/transfers")
    public ResponseEntity<TransferDto> performTransfer(@RequestBody TransferDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.performTransfer(dto));
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
