package io.elitejava3.BankAPI.services;

import io.elitejava3.BankAPI.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) { this.customerRepository = customerRepository; }

    // Verify
    public void verifyCustomer(Long id) {
        if (customerRepository.findCustomerById(id) == null) throw new RuntimeException();
    }

    // Create
    public Customer createCustomer(Customer customer) {
        return customerRepository.createCustomer(customer);
    }

    // Get
    public Customer getCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

    // Get
    public Customer getCustomerByAccountId(Long accountId) {
        return customerRepository.findCustomerByAccountId(accountId);
    }

    // Get All
    public List<Customer> getAllCustomers() {
        return customerRepository.findAllCustomers();
    }

    // Update
    public Customer udpateCustomer(Customer customer) {
        return customerRepository.saveCustomer(customer);
    }

    // Delete
    public void deleteCustomer(Long id) {
        customerRepository.deleteCustomerById(id);
    }
}
