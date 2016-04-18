package com.simpleinvoice.web;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
class IndexController {

	private final static String VIEW = "index";
	
	@RequestMapping(method = RequestMethod.GET)
	String index(Locale locale) {
		return VIEW;
	}
}