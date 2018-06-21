package io.elitejava3.BankAPI.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {
    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);
    public BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @RequestMapping(value = "/accounts/{accountId}/bills",method = RequestMethod.GET)
    public ResponseEntity<?> getBillByAccountId(@PathVariable Long accountId) {
        log.info("Getting Bill By Account Id : " + accountId);
        return new ResponseEntity<>(billService.getAllBillByAccountId(accountId), HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}/bills",method = RequestMethod.GET)
    public ResponseEntity<?> getBillByCustomerId(@PathVariable Long customerId) {
        log.info("Getting Bill By Customer Id : " + customerId);
        return new ResponseEntity<>(billService.getBillsByCustomerId(customerId), HttpStatus.OK);
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
    public ResponseEntity<?> getBillById(@PathVariable Long billId){
        log.info("Getting Bill By Bill Id : " + billId);
        return new ResponseEntity<>(billService.getBillById(billId),HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}/bills",method = RequestMethod.POST)
    public ResponseEntity<?> createBillFromAccountId (@RequestBody Bill bill, @PathVariable Long accountId ){
        bill.setAccountId(new Account(accountId,null,null,null,null,null));
        bill = billService.createBill(bill,accountId);

        log.info("Creating a bill : " + bill);
        return new ResponseEntity<>(bill,HttpStatus.OK);

    }

    @RequestMapping(value = "/accounts/{accountId}/bills/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateBillFromAccountId(@RequestBody Bill bill, @PathVariable Long id,@PathVariable Long accountId ){
        HttpStatus status;
        Bill oldBill = billService.getBillById(id);
        bill.setAccountId(new Account(accountId,null,null,null,null,null));


        if (billService.updateBill(bill).equals(oldBill)){
            billService.updateBill(bill);
            log.info("Bill consist of  : ",oldBill);
            status = HttpStatus.OK;
            return new ResponseEntity<>(status);
        }else {
            billService.updateBill(bill);
            log.info("Bill didn't exist so created");
            status = HttpStatus.CREATED;
            log.info("Creating a updating Bill : " + bill);
            return new ResponseEntity<>(status);
        }

    }

    @RequestMapping(value = "/bills/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBillById (@PathVariable Long id){
        HttpStatus status;

        billService.deleteBill(id);
        status = HttpStatus.NO_CONTENT;
        log.info("deleted bill : " + id);
        return new ResponseEntity<>(status);
    }

}
