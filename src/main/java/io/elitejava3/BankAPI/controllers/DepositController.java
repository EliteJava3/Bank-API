package io.elitejava3.BankAPI.controllers;

import com.example.javacohort3.ZipCodeBank.domains.Deposit;
import com.example.javacohort3.ZipCodeBank.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

//@RestController
//public class DepositController {
//    @Autowired
//    private DepositService depositService;
//
//    public DepositController () {}
//
//    // Get All (For Account ID)
//    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
//    public ResponseEntity<?> getAllDepositsForAccountId(@PathVariable Long accountId) {
//        List<Deposit> deposits = depositService.getAllDepositsForAccountId(accountId);
//        return new ResponseEntity<>(deposits, HttpStatus.OK);
//    }
//
//    // Get Deposit (By ID)
//    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.GET)
//    public ResponseEntity<?> getDepositById(@PathVariable Long depositId) {
//        Deposit deposit = depositService.getDepositById(depositId);
//        return new ResponseEntity<>(deposit, HttpStatus.OK);
//    }
//
//    // Create Deposit
//    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.POST)
//    public ResponseEntity<?> createDepositFromAccountId(@RequestBody Deposit deposit, @PathVariable Long accountId) {
//
//
//        Deposit d = depositService.createDepositByFromAccountId(deposit, accountId);
//        return new ResponseEntity<>(d, HttpStatus.CREATED);
//    }
//
//    // Update Deposit
//    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.PUT)
//    public ResponseEntity<?> updateDepositById(@RequestBody Deposit deposit, @PathVariable Long depositId) {
//        Deposit old_deposit = depositService.getDepositById(depositId);
//        Deposit new_deposit = depositService.updateDeposit(deposit);
//        return new ResponseEntity<>(deposit, HttpStatus.OK);
//    }
//
//    // Delete Deposit
//    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.DELETE)
//    public ResponseEntity<?> deleteDepositById(@PathVariable Long depositId) {
//
//
//        // Deposit deposit = depositService.getDepositById(depositId);
//        depositService.deleteDeposit(depositId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}