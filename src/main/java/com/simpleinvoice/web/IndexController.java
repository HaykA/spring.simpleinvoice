package com.simpleinvoice.web;

import java.security.Principal;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simpleinvoice.services.UserService;

@Controller
@RequestMapping("/")
class IndexController {

	private final static String VIEW = "index";
	private final UserService userService;
	
	@Autowired
	IndexController(UserService userService) {
		this.userService = userService;
	}
		
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView index(Locale locale, Principal principal) {
		ModelAndView modelAndView = new ModelAndView(VIEW);
		if (principal != null) {
			modelAndView.addObject("user", userService.findByUsername(principal.getName()));
		}
		return modelAndView;
	}
}
