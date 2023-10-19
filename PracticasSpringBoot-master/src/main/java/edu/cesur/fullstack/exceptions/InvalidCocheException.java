package edu.cesur.fullstack.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCocheException extends RuntimeException {

	String msg;

	public InvalidCocheException(String msg) {
		super(msg);
	}

}