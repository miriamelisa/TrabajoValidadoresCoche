package edu.cesur.fullstack.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.validator.internal.util.logging.Log;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ValidCode implements ConstraintValidator<CodeValidation, String> {
	
	private static final Pattern CODE_PATTERN = Pattern.compile("^[A-Za-z]{3}\\d{3}$"); //Pattern.compile("^[A-Za-z]{3}\\d{3}$");

	@Override
	public void initialize(CodeValidation constraintAnnotation) {
	}	
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			log.info("Código null");
			return false;
		}
		
		Matcher matcher = CODE_PATTERN.matcher(value);
		return matcher.matches();
		
	
	}


}
