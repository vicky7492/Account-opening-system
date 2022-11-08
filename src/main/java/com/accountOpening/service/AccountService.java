package com.accountOpening.service;

import com.accountOpening.controller.forms.ClientForm;
import com.accountOpening.model.Account;
import com.accountOpening.model.ClientDetails;
import com.accountOpening.repository.AccountRepo;
import com.accountOpening.repository.ClientRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class AccountService {
    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private AccountRepo accountRepo;

    public String openAccount(ClientForm clientForm){

        ClientDetails clientDetails = new ObjectMapper().convertValue(clientForm, ClientDetails.class);
        Long clientId = clientRepo.save(clientDetails).getClientId();

        Account account = new Account(new Date(System.currentTimeMillis()),"Savings",clientId);

        Long accountNo = accountRepo.save(account).getAccountNo();

        return "Successfully Account Created with Account No : "+accountNo;
    }



}
