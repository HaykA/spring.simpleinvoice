package com.simpleinvoice.valueobjects;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.simpleinvoice.constraints.MatchingEmail;

@MatchingEmail
public class ControlEmail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotBlank @Email
	private String value;
	@NotBlank @Email
	private String controlValue;
	
	public ControlEmail() {}

	public ControlEmail(String value, String controlValue) {
		this.value = value;
		this.controlValue = controlValue;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getControlValue() {
		return controlValue;
	}

	public void setControlValue(String controlValue) {
		this.controlValue = controlValue;
	}
}
