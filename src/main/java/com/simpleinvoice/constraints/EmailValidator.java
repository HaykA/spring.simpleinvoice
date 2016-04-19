package com.simpleinvoice.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.simpleinvoice.valueobjects.ControlEmail;

public class EmailValidator implements  ConstraintValidator<MatchingEmail, ControlEmail> {

	@Override
	public void initialize(MatchingEmail constraintAnnotation) {}

	@Override
	public boolean isValid(ControlEmail email, ConstraintValidatorContext context) {
		return email.getValue().equalsIgnoreCase(email.getControlValue());
	}

}
