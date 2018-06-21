package io.elitejava3.BankAPI.controllers;

import io.elitejava3.BankAPI.domains.Account;
import io.elitejava3.BankAPI.domains.Customer;
import io.elitejava3.BankAPI.services.AccountService;
import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
public class AccountController {
    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) { this.accountService = accountService; }

    // Get account by its ID
    @RequestMapping(value = "customers/{customerId}/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountByID(@PathVariable Long accountId){
        HttpStatus status;
        Object response;
        Account account = accountService.getAccountById(accountId);

        accountService.verifyAccountById(accountId);

        log.info("[Get]" + account);
        status = HttpStatus.OK;
        response = account;

        return new ResponseEntity<>(response, status);
    }

    // Get All accounts from a customer
    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccountsByCustomerId(@PathVariable Long customerId) {
        HttpStatus status = HttpStatus.OK;
        accountService.verifyCustomerById(customerId);
        List<Account> accounts = accountService.getAccountsByCustomerId(customerId);
        log.info("[Get]" + customerId);
        return new ResponseEntity<>(accounts, status);
    }

    // Create Account
    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccountFromCustomerId(@RequestBody Account account, @PathVariable Long customerId){
        HttpStatus status = HttpStatus.CREATED;

        account.setCustomer(accountService.getCustomerById(customerId));
        accountService.getCustomerById(customerId).setAccount(account);

        Account a = accountService.createAccount(account);
        accountService.verifyAccountById(a.getId());


        log.info("[POST] " + a);
        return new ResponseEntity<>(a, status);
    }

    // update account
    @RequestMapping(value = "/customers/{customerId}/accounts/{accountId}", method = RequestMethod.PUT)
    public  ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable Long customerId ,@PathVariable Long accountId) {
        HttpStatus status;


        Account oldAccount = accountService.updateAccount(account);


        if(oldAccount.equals(accountService.getAccountById(accountId))){
            // account.setCustomer(new Customer(customerId,null,"","",null));
            Account a = accountService.createAccount(account);
            log.info("[updated]" + account);
            status = HttpStatus.OK;
            return new ResponseEntity<>(a,status);
        }else{
            log.info("[created]" + account);
            status = HttpStatus.CREATED;
            return new ResponseEntity<>(status);
        }


    }

    // delete account
    @RequestMapping(value = "/customers/{customerId}/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleAccountById(@PathVariable Long accountId){
        HttpStatus status = HttpStatus.NO_CONTENT;

        accountService.deleteAccount(accountId);
        log.info("Deleted" + accountId);

        return new ResponseEntity<> (status);
    }

}