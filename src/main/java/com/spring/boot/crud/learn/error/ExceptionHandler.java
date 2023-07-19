package com.spring.boot.crud.learn.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    
    // add exception handling code
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ErrorRespone> handleException(Exception ex){
	
	
	ErrorRespone error = new ErrorRespone();
	error.setStatus(HttpStatus.BAD_REQUEST.value());
	error.setMessage(ex.getMessage());
	error.setTimestamp(System.currentTimeMillis());
	return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY);
    }
    
}
