package io.elitejava3.BankAPI.controllers;

import io.elitejava3.BankAPI.domains.Customer;
import io.elitejava3.BankAPI.services.CustomerService;
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
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);
    @Autowired
    private CustomerService customerService;

    // Get all Customers
    @RequestMapping("/customers")
    public ResponseEntity<?> getAllCustomers() {
        customerService.verifyCustomer(new Long(1));
        List<Customer> customers = customerService.getAllCustomers();

        log.info("[GET ALL PEOPLE]: " + customers);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Get Customer By their ID
    @RequestMapping("/customers/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        // throw error if (customer == null)
        customerService.verifyCustomer(id);
        Customer customer = customerService.getCustomerById(id);

        // if they do exist
        log.info("[GET BY ID]: " + customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // Create a new Customer
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        Customer c = customerService.createCustomer(customer);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newUri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/id")
                .buildAndExpand(c.getId())
                .toUri();
        httpHeaders.setLocation(newUri);

        log.info("[POST " + c);
        return new ResponseEntity<>(c,httpHeaders, HttpStatus.CREATED);
    }

    // Update a Customer by their ID
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        customerService.verifyCustomer(id);
        Customer c = customerService.updateCustomer(customer);

        log.info("[PUT-UPDATE]: " + customer);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        customerService.verifyCustomer(id);
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}