package io.elitejava3.BankAPI.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Withdraw {
    @Id
    private Long id;
    private TransactionType type;//enum serialize to a string
    private String trasnaction_date;
    private String transaction_status;
    private String payee_id;
    private Medium medium; //enum serialized to a string
    private String description;
    private Account account;

    public Deposit(){}

    public Deposit(Long id, TransactionType type, String trasnaction_date, String transaction_status, String payee_id, Medium medium, String description, Account account) {
        this.id = id;
        this.type = type;
        this.trasnaction_date = trasnaction_date;
        this.transaction_status = transaction_status;
        this.payee_id = payee_id;
        this.medium = medium;
        this.description = description;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getTrasnaction_date() {
        return trasnaction_date;
    }

    public void setTrasnaction_date(String trasnaction_date) {
        this.trasnaction_date = trasnaction_date;
    }

    public String getTransaction_status() {
        return transaction_status;
    }

    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }

    public String getPayee_id() {
        return payee_id;
    }

    public void setPayee_id(String payee_id) {
        this.payee_id = payee_id;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "id=" + id +
                ", type=" + type +
                ", trasnaction_date='" + trasnaction_date + '\'' +
                ", transaction_status='" + transaction_status + '\'' +
                ", payee_id='" + payee_id + '\'' +
                ", medium=" + medium +
                ", description=" + description +
                ", account=" + account +
                '}';
    }
}
