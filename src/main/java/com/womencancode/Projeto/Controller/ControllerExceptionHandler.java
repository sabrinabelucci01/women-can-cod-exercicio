package com.womencancode.Projeto.Controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.womencancode.Projeto.Exception.DuplicatedKeyException;
import com.womencancode.Projeto.Exception.EntityNotFoundException;
import com.womencancode.Projeto.Exception.InvalidFieldException;
import com.womencancode.Projeto.model.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler({InvalidFieldException.class, EntityNotFoundException.class, JsonMappingException.class})
    public ResponseEntity<Error> serviceException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(DuplicatedKeyException.class)
    public ResponseEntity<Error> duplicatedKeyException(Exception ex) {
        Log.error(ex.getMessage(), ex);
        return buildResponseEntity(HttpStatus.CONFLICT, ex);
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<Error> defaultException(Exception ex) {
        Log.error("A wild internal server error appears!", ex);
        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    private ResponseEntity<Error> buildResponseEntity(HttpStatus status, Exception ex) {
        Error error = buildError(status.value(), ex);
        return new ResponseEntity<>(error, status);
    }

    private Error buildError(int status, Exception ex) {
        return Error.builder()
                .status(status)
                .message(ex.getMessage())
                .build();
    }
}