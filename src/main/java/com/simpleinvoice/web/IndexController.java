package com.simpleinvoice.web;

import static com.simpleinvoice.util.Attributes.USER;
import static com.simpleinvoice.util.InternalResourceResolver.INDEX;
import static com.simpleinvoice.util.InternalResourceResolver.ROOT;

import java.security.Principal;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simpleinvoice.services.UserService;

@Controller
@RequestMapping(ROOT)
class IndexController {

	private final UserService userService;
	
	@Autowired
	IndexController(UserService userService) {
		this.userService = userService;
	}
		
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView index(Locale locale, Principal principal) {
		ModelAndView modelAndView = new ModelAndView(INDEX);
		if (principal != null) {
			modelAndView.addObject(USER, userService.findByUsername(principal.getName()));
		}
		return modelAndView;
	}
}
