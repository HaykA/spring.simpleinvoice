package com.simpleinvoice.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.simpleinvoice.valueobjects.ControlEmail;

public class EmailValidator implements  ConstraintValidator<MatchingEmail, ControlEmail> {

	@Override
	public void initialize(MatchingEmail constraintAnnotation) {}

	@Override
	public boolean isValid(ControlEmail controlEmail, ConstraintValidatorContext context) {
		return controlEmail.getValue().equalsIgnoreCase(controlEmail.getControlValue());
	}

}
