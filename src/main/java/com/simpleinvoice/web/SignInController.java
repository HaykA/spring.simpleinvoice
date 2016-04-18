package com.simpleinvoice.web;

import java.security.Principal;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/signin")
public class SignInController {
	private final static String VIEW = "signin";
	private final static String REDIRECT_TO_INDEX = "redirect:/";


	@RequestMapping(method = RequestMethod.GET)
	String signin(Locale locale, Principal principal) {
		if (principal == null) {
			return VIEW;
		}
		return REDIRECT_TO_INDEX;
	}
	
	@RequestMapping(params = "logout", method = RequestMethod.GET)
	String signout(Locale locale) {
		return REDIRECT_TO_INDEX;
	}
}
