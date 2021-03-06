package com.thiago.postsApi.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.thiago.postsApi.services.exceptions.ElementNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ElementNotFoundException.class)
	public ResponseEntity<StandardError> elementNotFoundHandler(ElementNotFoundException e, HttpServletRequest request){
		
		StandardError error = new StandardError();
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError("Resource not Found");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
		
	}

}
