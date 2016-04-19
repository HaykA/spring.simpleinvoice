package com.simpleinvoice.valueobjects;

import java.io.Serializable;

import com.simpleinvoice.constraints.Password;

public class ControlPassword implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Password
	private String value;
	@Password
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
}
