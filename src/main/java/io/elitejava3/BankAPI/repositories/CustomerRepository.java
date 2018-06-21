package io.elitejava3.BankAPI.repositories;

import io.elitejava3.BankAPI.domains.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findCustomerById(Long id);
    //Customer findCustomerByAccountId(Long accountId);



}
