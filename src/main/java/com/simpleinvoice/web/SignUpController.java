package com.simpleinvoice.web;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/signup")
public class SignUpController {
	private final static String VIEW = "signup";
	
	@SuppressWarnings("unused")
	private static final String PUBLIC_KEY = "6LfQth0TAAAAAOWIw1a4oZ3T6DUO8fxP_UfRk_Fs";
	@SuppressWarnings("unused")
	private static final String PRIVATE_KEY = "6LfQth0TAAAAAAeTFAvS9bwc5iiAU5cf7rfrhiN5";
	
	@RequestMapping(method = RequestMethod.GET)
	String signup(Locale locale) {
		return VIEW;
	}
}
