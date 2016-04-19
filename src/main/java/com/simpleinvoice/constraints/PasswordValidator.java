package com.simpleinvoice.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.simpleinvoice.valueobjects.ControlPassword;

public class PasswordValidator implements  ConstraintValidator<MatchingPassword, ControlPassword> {

	@Override
	public void initialize(MatchingPassword constraintAnnotation) {}

	@Override
	public boolean isValid(ControlPassword controlPassword, ConstraintValidatorContext context) {
		return controlPassword.getValue().equals(controlPassword.getControlValue());
	}

}
