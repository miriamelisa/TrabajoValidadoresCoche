package edu.cesur.fullstack.exceptions.handlers;

import java.net.URI;
import java.time.Instant;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.cesur.fullstack.controllers.CocheRestController;
import edu.cesur.fullstack.exceptions.CocheNotFoundException;
import edu.cesur.fullstack.exceptions.InvalidCocheException;
import edu.cesur.fullstack.exceptions.PersonaNotFoundException;

@RestControllerAdvice
//public class GlobalExceptionsHandler  extends ResponseEntityExceptionHandler {
public class GlobalExceptionsHandler  {

	@ExceptionHandler( CocheNotFoundException.class )
	public ProblemDetail handleCocheNotFoundException(CocheNotFoundException e) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Custom Exception Occurred");
		problemDetail.setType(URI.create("http://cesurformacion.com"));
		problemDetail.setProperty("errorCategory", "Coche");
		problemDetail.setProperty("timeStamp", Instant.now());

		return problemDetail;
	}
	
	
	@ExceptionHandler(InvalidCocheException.class)
	public ProblemDetail handlerCocheNotFoundException(InvalidCocheException e) {
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
		problemDetail.setTitle("Coustom Exception Occuder");
		problemDetail.setType(URI.create("http://localhost/8080/coches"));
		problemDetail.setProperty("errorCategory", "Coche");
		problemDetail.setProperty("timeStamp", Instant.now());
		
		return problemDetail;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail handlerCocheNotFoundException(MethodArgumentNotValidException e) {
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
		problemDetail.setTitle("Coustom Exception Occuder");
		problemDetail.setType(URI.create("http://localhost/8080/coches"));
		problemDetail.setProperty("errorCategory", "Coche");
		problemDetail.setProperty("timeStamp", Instant.now());
		
		return problemDetail;
	}

//	@ExceptionHandler({ CocheNotFoundException.class, PersonaNotFoundException.class })
//	public ProblemDetail handleNotFoundException(RuntimeException e) {
//
//		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
//		problemDetail.setTitle("Custom Exception Occurred");
//		problemDetail.setType(URI.create("http://cesurformacion.com"));
//		problemDetail.setProperty("timeStamp", Instant.now());
//
//		if (e instanceof CocheNotFoundException) {
//			problemDetail.setProperty("errorCategory", "Coche");
//		} else if (e instanceof PersonaNotFoundException) {
//			problemDetail.setProperty("errorCategory", "Persona");
//		}
//
//		return problemDetail;
//	}
	
	
	
	
	
}
