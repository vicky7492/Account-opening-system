package com.accountOpening.controller;

import com.accountOpening.controller.forms.ClientForm;
import com.accountOpening.model.Account;
import com.accountOpening.model.ClientDetails;
import com.accountOpening.repository.AccountRepo;
import com.accountOpening.repository.ClientRepo;
import com.accountOpening.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private ClientRepo clientRepo;

    @GetMapping("/showclients")
    public ResponseEntity<List<ClientDetails>> ShowClients(){
        return ResponseEntity.ok(clientRepo.findAll());
    }

    @GetMapping("/showaccounts")
    public ResponseEntity<List<Account>> ShowAccounts(){
        return ResponseEntity.ok(accountRepo.findAll());
    }


    @GetMapping("/client/{id}")
    public ResponseEntity<ClientDetails> showClientById(@PathVariable Long id){
        return ResponseEntity.ok(clientRepo.findById(id).orElse(null));
    }


    @GetMapping("/account/{id}")
    public ResponseEntity<Account> showAccountById(@PathVariable Long id){
        return ResponseEntity.ok(accountRepo.findById(id).orElse(null));
    }


    @PostMapping("/register")
    public String accountOpening(@RequestBody ClientForm clientForm){
        String message = accountService.openAccount(clientForm);

        return message;
    }

    @PutMapping("/client/update")
    public ResponseEntity<ClientDetails> updateClient(@RequestBody ClientDetails clientDetails) {
        return ResponseEntity.ok(clientRepo.save(clientDetails));
    }
}
