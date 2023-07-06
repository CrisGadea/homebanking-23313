package com.ar.bankingonline.application.services;

import com.ar.bankingonline.api.dtos.TransferDto;
import com.ar.bankingonline.api.mappers.TransferMapper;
import com.ar.bankingonline.application.exceptions.InsufficientFundsException;
import com.ar.bankingonline.domain.exceptions.AccountNotFoundException;
import com.ar.bankingonline.domain.exceptions.TransferNotFoundException;
import com.ar.bankingonline.domain.models.Account;
import com.ar.bankingonline.domain.models.Transfer;
import com.ar.bankingonline.infrastructure.repositories.AccountRepository;
import com.ar.bankingonline.infrastructure.repositories.TransfersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferService {

    @Autowired
    private TransfersRepository repository;

    @Autowired
    private AccountRepository accountRepository;

    public TransferService(TransfersRepository repository){
        this.repository = repository;
    }

    // TODO: Completar el CRUD del Service


    public List<TransferDto> getTransfers(){
        List<Transfer> transfers = repository.findAll();
        return transfers.stream()
                .map(TransferMapper::transferToDto)
                .collect(Collectors.toList());
    }

    public TransferDto getTransferById(Long id){
        Transfer transfer = repository.findById(id).orElseThrow(() ->
                new TransferNotFoundException("Transfer not found with id: " + id));
        return TransferMapper.transferToDto(transfer);
    }

    public TransferDto createTransfer(TransferDto transferDto){
        // TODO: Buscar un Account por number
        Transfer transfer = TransferMapper.dtoToTransfer(transferDto);
        return TransferMapper.transferToDto(repository.save(transfer));
    }

    public TransferDto updateTransfer(Long id, TransferDto transferDto){
        Transfer transfer = repository.findById(id).orElseThrow(() -> new TransferNotFoundException("Transfer not found with id: " + id));
        Transfer updatedTransfer = TransferMapper.dtoToTransfer(transferDto);
        updatedTransfer.setId(transfer.getId());
        return TransferMapper.transferToDto(repository.save(updatedTransfer));
    }

    public String deleteTransfer(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "Se ha eliminado la transferencia";
        } else {
            return "No se ha eliminado la transferencia";
        }
    }

    // TODO: Llamar al método en el momento de la creación
    @Transactional
    public TransferDto performTransfer(Long idOrigin, Long idDestination, BigDecimal amount) {
        // Comprobar si las cuentas de origen y destino existen
        Account originAccount = accountRepository.findById(idOrigin)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + idOrigin));
        Account destinationAccount = accountRepository.findById(idDestination)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + idDestination));

        // Comprobar si la cuenta de origen tiene fondos suficientes
        if (originAccount.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds in the account with id: " + idOrigin);
        }

        // Realizar la transferencia
        originAccount.setBalance(originAccount.getBalance().subtract(amount));
        destinationAccount.setBalance(destinationAccount.getBalance().add(amount));

        // Guardar las cuentas actualizadas
        accountRepository.save(originAccount);
        accountRepository.save(destinationAccount);

        // TODO: Validar que en ambas cuentas se haya realizado la operación de manera correcta
        // Es decir, si todo sale bien, se debeería guardar la transfer en la BD

        // Crear la transferencia y guardarla en la base de datos
        Transfer transfer = new Transfer();
        // Creamos un objeto del tipo Date para obtener la fecha actual
        Date date = new Date();
        // Seteamos el objeto fecha actual en el transferDto
        transfer.setDate(date);
        transfer.setOrigin(originAccount.getNumber());
        transfer.setTarget(destinationAccount.getNumber());
        transfer.setAmount(amount);
        transfer = repository.save(transfer);

        // Devolver el DTO de la transferencia realizada
        return TransferMapper.transferToDto(transfer);
    }


}
