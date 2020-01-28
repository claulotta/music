package hu.flowacademy.musicstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class GlobalExeptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<String> handleResponseStatusException(ValidationException e) {
        System.err.println("got a validation error: " + e);
        return List.of(e.getMessage());
    }
}
