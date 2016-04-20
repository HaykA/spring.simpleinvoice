package com.simpleinvoice.web;

import static com.simpleinvoice.util.InternalResourceResolver.INDEX;
import static com.simpleinvoice.util.InternalResourceResolver.SIGNIN;
import static com.simpleinvoice.util.InternalResourceResolver._SIGNIN;
import static com.simpleinvoice.util.InternalResourceResolver.redirectTo;

import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(_SIGNIN)
public class SignInController {

	@RequestMapping(method = RequestMethod.GET)
	String signin(Locale locale, Principal principal, HttpServletRequest request) {
		if (principal == null) {
			return SIGNIN;
		}
		return redirectTo(INDEX);
	}
	
	@RequestMapping(params = "logout", method = RequestMethod.GET)
	String signout(Locale locale) {
		return redirectTo(INDEX);
	}
}
