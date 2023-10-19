package edu.cesur.fullstack.validators;

import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PersonCodeValidator implements ConstraintValidator<ValidPersonCode, String> {

	//definimos el patrón con java regex
	private static final Pattern CODE_PATTERN = Pattern.compile("^[A-Za-z]{3}\\d{3}$");

	@Override
	public void initialize(ValidPersonCode constraintAnnotation) {
	}

	@Override
	public boolean isValid(String code, ConstraintValidatorContext context) {
		if (code == null) {
			return false;
		}
		return CODE_PATTERN.matcher(code).matches(); //hacemos la comparación del imput
	}
}