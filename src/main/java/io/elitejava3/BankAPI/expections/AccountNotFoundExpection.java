package io.elitejava3.BankAPI.expections;

public class AccountNotFoundExpection extends RuntimeException {
    public AccountNotFoundExpection() {
    }

    public AccountNotFoundExpection(String message) {
        super(message);
    }

    public AccountNotFoundExpection(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountNotFoundExpection(Throwable cause) {
        super(cause);
    }

    public AccountNotFoundExpection(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
