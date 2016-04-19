package com.simpleinvoice.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
@SessionAttributes("form")
public class TestController {
	private final static String VIEW = "test";
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView test(Locale locale, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(VIEW);
		HttpSession session = request.getSession();
		modelAndView.addObject("form1", session.getAttribute("form"));
		session.removeAttribute("form");
		return modelAndView;
	}
	
}
