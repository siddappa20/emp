package com.ssit.emp.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public Map<Object, String> validationException(ConstraintViolationException e){

        Map<Object, String> map = new HashMap<>();
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            System.out.println(constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
            map.put(constraintViolation.getPropertyPath(), constraintViolation.getMessage());
        }
        //return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        return map;
   }



}
