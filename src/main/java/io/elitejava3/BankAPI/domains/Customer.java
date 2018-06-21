package io.elitejava3.BankAPI.domains;

import javax.persistence.*;
import java.util.Set;

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Account account;
    public String first_name;
    public String last_name;
    @OneToMany
    @JoinColumn
    public Set<Address> addresses;

    public Customer(){}

    public Customer(Long id, Long accountId, String first_name, String last_name, Set<Address> addresses) {
        this.id = id;
        this.accountId = accountId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.addresses = addresses;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
