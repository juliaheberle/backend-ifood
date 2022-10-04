package br.com.restaurante.ifood.handler;

import br.com.restaurante.ifood.exception.ExceptionsDetails;
import br.com.restaurante.ifood.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionsDetails> notfoundException(NotFoundException ex){
        return new ResponseEntity<>(ExceptionsDetails.builder()
                .dateTime(LocalDateTime.now())
                .erro("Not Found")
                .message(ex.getMessage())
                .statusHttp(HttpStatus.NOT_FOUND.value())
                .build(), HttpStatus.NOT_FOUND);
    }
}
