package com.simpleinvoice.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface MatchingPassword {
	String message() default "{com.simpleinvoice.constraints.MatchingPassword}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
