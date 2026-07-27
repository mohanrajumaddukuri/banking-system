package com.banking.banking_system.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFound(CustomerNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidationException(
	        MethodArgumentNotValidException ex) {

	    List<String> errors = ex.getBindingResult()
	            .getFieldErrors()
	            .stream()
	            .map(error -> error.getDefaultMessage())
	            .toList();

	    Map<String, Object> response = new HashMap<>();

	    response.put("status", 400);
	    response.put("message", "Validation Failed");
	    response.put("errors", errors);

	    return ResponseEntity.badRequest().body(response);

	}
	
}
