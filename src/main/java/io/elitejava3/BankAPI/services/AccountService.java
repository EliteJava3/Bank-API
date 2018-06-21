package io.elitejava3.BankAPI.services;

import io.elitejava3.BankAPI.domains.Account;
import io.elitejava3.BankAPI.domains.Customer;
import io.elitejava3.BankAPI.exceptions.ResourceNotFoundException;
import io.elitejava3.BankAPI.repositories.AccountRepository;
import io.elitejava3.BankAPI.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceResolverChain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private AccountRepository accountRepository;
    private CustomerService customerService;

    @Autowired
    public AccountService(AccountRepository accountRepository, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
    }

    public void verifyCustomerById(Long id) {
        customerService.verifyCustomer(id);
    }

    public void verifyAccountById(Long id){
        if (accountRepository.findAccountById(id) == null) throw new ResourceNotFoundException();
    }

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public Customer getCustomerById(Long customerId) {
       return customerService.getCustomerById(customerId);

    }

    public List<Account> getAccountsByCustomerId(Long customerId){
        customerService.verifyCustomer(customerId);

        ArrayList<Account> accounts = (ArrayList<Account>) accountRepository.findAll();
        accounts.removeIf(a -> !a.getCustomer().getId().equals(customerId));

        return accounts;
    }

    public Account getAccountById (Long id){
        return accountRepository.findAccountById(id);
    }

    public Account updateAccount(Account account){
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id){
        accountRepository.deleteAccountById(id);
    }
}