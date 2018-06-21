package io.elitejava3.BankAPI.handler;

import io.elitejava3.BankAPI.exceptions.ResourceNotFoundException;
import io.elitejava3.BankAPI.exceptions.ResponeDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleAccountNotFoundException(ResourceNotFoundException anfe){
        ResponeDetails responeDetails = new ResponeDetails();
        responeDetails.setStatus(HttpStatus.NOT_FOUND.value());
        responeDetails.setMessage("“error fetching accounts”");

        return new ResponseEntity<>(responeDetails,null);
    }

}
