package edu.cesur.fullstack.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PersonCodeValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPersonCode {

    String message() default "Código inválido. Debe contener exactamente 3 letras seguidas de 3 números.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "PREFIX-";
}