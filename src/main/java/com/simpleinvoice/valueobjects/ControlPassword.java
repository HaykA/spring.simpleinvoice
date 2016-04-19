package com.simpleinvoice.valueobjects;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.simpleinvoice.constraints.MatchingPassword;

@MatchingPassword
public class ControlPassword implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String value;
	@NotBlank
	private String controlValue;
	
	public ControlPassword() {}
	
	public ControlPassword(String value, String controlValue) {
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
	
	public void clear() {
		value = null;
		controlValue = null;
	}
}
