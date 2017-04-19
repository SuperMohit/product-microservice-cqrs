package com.mohit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	    @ExceptionHandler(value = { Exception.class })
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public ResponseEntity unknownException(Exception ex, WebRequest req) {
	    	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	    }
	}

