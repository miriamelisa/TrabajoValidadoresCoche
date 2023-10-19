package edu.cesur.fullstack.exceptions;

public class PersonaNotFoundException extends RuntimeException {

	public PersonaNotFoundException(String message) {
        super(message);
    }
}
