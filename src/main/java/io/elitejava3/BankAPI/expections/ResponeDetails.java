package io.elitejava3.BankAPI.expections;

public class ResponeDetails {
    private int status;
    private String message;


    public ResponeDetails() {
    }

    public ResponeDetails(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
