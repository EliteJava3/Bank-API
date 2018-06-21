package io.elitejava3.BankAPI.handler;

import io.elitejava3.BankAPI.expections.AccountNotFoundExpection;
import io.elitejava3.BankAPI.expections.ResponeDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(AccountNotFoundExpection.class)
    public ResponseEntity<?> handleAccountNotFoundException(AccountNotFoundExpection anfe){
        ResponeDetails responeDetails = new ResponeDetails();
        responeDetails.setStatus(HttpStatus.NOT_FOUND.value());
        responeDetails.setMessage("“error fetching accounts”");

        return new ResponseEntity<>(responeDetails,null);
    }

}
