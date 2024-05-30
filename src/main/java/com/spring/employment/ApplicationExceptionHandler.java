package com.spring.employment;

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

import com.spring.employment.exception.DeleteException;
import com.spring.employment.exception.EmployeeDataIntegrityException;
import com.spring.employment.exception.EmployeeNotEmployedException;
import com.spring.employment.exception.EmployeeNotFoundException;
import com.spring.employment.exception.EmployerNotFoundException;
import com.spring.employment.exception.ErrorResponse;
import com.spring.employment.exception.RatingNotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ EmployerNotFoundException.class, RatingNotFoundException.class, EmployeeNotFoundException.class,
            EmployeeNotEmployedException.class })
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
        ErrorResponse error = new ErrorResponse(Arrays.asList("Cannot delete non-existing resources"));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeDataIntegrityException.class)
    public ResponseEntity<Object> handleEmployeeDataIntegrityException(EmployeeDataIntegrityException ex) {
        ErrorResponse error = new ErrorResponse(Arrays.asList(ex.getMessage()));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ErrorResponse error = new ErrorResponse(
                Arrays.asList("Data Integrity Violation: We cannot process your request."));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("null")
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> errors.add(error.getDefaultMessage()));

        return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
    }
}
