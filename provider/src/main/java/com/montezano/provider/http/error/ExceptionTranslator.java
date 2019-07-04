package com.montezano.provider.http.error;

import com.montezano.provider.domain.error.AccountNotFoundException;
import com.montezano.provider.domain.error.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
@Slf4j
public class ExceptionTranslator {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> illegalArgument(final IllegalArgumentException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("Illegal argument");
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = AccountNotFoundException.class)
    public ResponseEntity<ExceptionResponse> accountNotFound(final AccountNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("Not found");
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(final Exception ex){
        log.error("handleException", ex);
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("Internal Server Error");
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
