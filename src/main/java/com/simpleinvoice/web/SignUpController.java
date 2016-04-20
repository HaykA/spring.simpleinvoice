package com.simpleinvoice.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.simpleinvoice.forms.UserForm;
import com.simpleinvoice.services.UserAuthorityService;
import com.simpleinvoice.services.UserService;

@Controller
@RequestMapping("/signup")
@SessionAttributes("form")
public class SignUpController {
	private final static String VIEW = "signup";
	private final static String REDIRECT_TO_SIGNIN = "redirect:/signin";
	
	private final UserService userService;
	private final UserAuthorityService userAuthorityService;
	
	@Autowired
	public SignUpController(UserService userService, UserAuthorityService userAuthorityService) {
		this.userService = userService;
		this.userAuthorityService = userAuthorityService;
	}
	
	@InitBinder("userForm")
	void initBinderUserForm(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
	
	@SuppressWarnings("unused")
	private static final String PUBLIC_KEY = "6LfQth0TAAAAAOWIw1a4oZ3T6DUO8fxP_UfRk_Fs";
	@SuppressWarnings("unused")
	private static final String PRIVATE_KEY = "6LfQth0TAAAAAAeTFAvS9bwc5iiAU5cf7rfrhiN5";
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView begin(Locale locale) {
		return new ModelAndView(VIEW).addObject(new UserForm());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	String validate(Locale locale, @Validated UserForm userForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("form has " + bindingResult.getErrorCount() + " errors");
			bindingResult.getAllErrors().stream().forEach(System.out::println);
			userForm.clearPassword();
			return VIEW;
		} else {
			userService.create(userForm.createUser(userAuthorityService.findByName("user")));
			return REDIRECT_TO_SIGNIN;
		}
		
	}
}
