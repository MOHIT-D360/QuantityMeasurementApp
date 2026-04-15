package com.app.quantitymeasurement.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;

class ErrorResponse {
	public LocalDateTime timeStamp;
	public int status;
	public String error;
	public String message;
	public String path;
}

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex, WebRequest request) {

		HashMap<String, String> errors = new HashMap<>();

		ex.getBindingResult()
				.getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		log.info(errors.toString());

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.timeStamp = LocalDateTime.now();
		errorResponse.status = HttpStatus.BAD_REQUEST.value();
		errorResponse.error = "Validation Error";
		errorResponse.message = errors.toString();
		errorResponse.path = request.getDescription(false).replace("uri=", "");

		return ResponseEntity.badRequest().body(errorResponse);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(
			UserNotFoundException ex, WebRequest request) {

		log.info(ex.getMessage());

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.timeStamp = LocalDateTime.now();
		errorResponse.status = HttpStatus.NOT_FOUND.value();
		errorResponse.error = "User Not Found";
		errorResponse.message = ex.getMessage();
		errorResponse.path = request.getDescription(false).replace("uri=", "");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

	@ExceptionHandler({ BadCredentialsException.class, UsernameNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleAuthenticationException(
			RuntimeException ex, WebRequest request) {

		log.info(ex.getMessage());

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.timeStamp = LocalDateTime.now();
		errorResponse.status = HttpStatus.UNAUTHORIZED.value();
		errorResponse.error = "Authentication Failed";
		errorResponse.message = "Invalid email or password";
		errorResponse.path = request.getDescription(false).replace("uri=", "");

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ErrorResponse> handleMethodNotSupportedException(
			HttpRequestMethodNotSupportedException ex, WebRequest request) {

		log.info(ex.getMessage());

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.timeStamp = LocalDateTime.now();
		errorResponse.status = HttpStatus.METHOD_NOT_ALLOWED.value();
		errorResponse.error = "Method Not Allowed";
		errorResponse.message = ex.getMessage();
		errorResponse.path = request.getDescription(false).replace("uri=", "");

		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorResponse);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex, WebRequest request) {

		log.info(ex.getMessage());

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.timeStamp = LocalDateTime.now();
		errorResponse.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
		errorResponse.error = "Internal Server Error";
		errorResponse.message = ex.getMessage();
		errorResponse.path = request.getDescription(false).replace("uri=", "");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
}