package io.elitejava3.BankAPI.domains;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @Transient
    private Account account;
    private String first_name;
    private String last_name;
    @ElementCollection
    @Transient
    private Set<Address> addresses;

    public Customer(){}

    public Customer(Long id, String first_name, String last_name, Set<Address> addresses) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.addresses = addresses;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }

    public String getFirst_name() { return first_name; }
    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }
    public void setLast_name(String last_name) { this.last_name = last_name; }

    public Set<Address> getAddresses() { return addresses; }
    public void setAddresses(Set<Address> addresses) { this.addresses = addresses; }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", account=" + account +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
