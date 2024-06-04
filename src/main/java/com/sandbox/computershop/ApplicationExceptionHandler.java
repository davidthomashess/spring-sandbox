package com.sandbox.computershop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sandbox.computershop.exception.BrandNotFoundException;
import com.sandbox.computershop.exception.CustomerWithoutBrandException;
import com.sandbox.computershop.exception.CustomerNotFoundException;
import com.sandbox.computershop.exception.DeleteException;
import com.sandbox.computershop.exception.ErrorResponse;
import com.sandbox.computershop.exception.RatingNotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ BrandNotFoundException.class, RatingNotFoundException.class, CustomerNotFoundException.class,
            CustomerWithoutBrandException.class })
    public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex) {
        ErrorResponse error = new ErrorResponse(Arrays.asList(ex.getMessage()));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DeleteException.class)
    public ResponseEntity<Object> handleDeleteException(DeleteException ex) {
        ErrorResponse error = new ErrorResponse(Arrays.asList(ex.getMessage()));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleDataAccessException(EmptyResultDataAccessException ex) {
        ErrorResponse error =

                new ErrorResponse(Arrays.asList("Cannot delete non-existing resource"));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ErrorResponse error = new ErrorResponse(
                Arrays.asList("Data Integrity Violation: we cannot process your request."));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("null")
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest reqeust) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> errors.add(error.getDefaultMessage()));

        return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
    }

}