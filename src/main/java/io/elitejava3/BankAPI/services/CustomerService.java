package io.elitejava3.BankAPI.services;

import io.elitejava3.BankAPI.domains.Customer;
import io.elitejava3.BankAPI.exceptions.ResourceNotFoundException;
import io.elitejava3.BankAPI.repositories.AddressRepository;
import io.elitejava3.BankAPI.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    // Verify
    public void verifyCustomer(Long id) {
        if (customerRepository.findCustomerById(id) == null) throw new ResourceNotFoundException();
    }

    // Create
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get
    public Customer getCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

    // Get All
    public List<Customer> getAllCustomers() {
        return (ArrayList<Customer>) customerRepository.findAll();
    }

    // Update
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Delete
    public void deleteCustomer(Long id) {
        customerRepository.deleteCustomerById(id);
    }
}