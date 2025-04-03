package com.bank.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	// Handle Specific Type Of Exception
	@ExceptionHandler(AccountException.class)
	public ResponseEntity<ErrorDetails> globalSpecififcHandler(AccountException accountException,WebRequest webRequest)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),accountException.getMessage(),webRequest.getDescription(false),"ACCOUNT_NOT_FOUND");
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	// Handle Generic  Type Of Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> globalSpecififcHandler(Exception exception,WebRequest webRequest)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),exception.getMessage(),webRequest.getDescription(false),"INTERNAL_SERVER_ERROR");
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
}
