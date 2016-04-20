package com.simpleinvoice.web;

import static com.simpleinvoice.util.InternalResourceResolver.SIGNIN;
import static com.simpleinvoice.util.InternalResourceResolver.SIGNUP;
import static com.simpleinvoice.util.InternalResourceResolver._SIGNUP;
import static com.simpleinvoice.util.InternalResourceResolver.redirectTo;
import static com.simpleinvoice.util.Attributes.*;

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
@RequestMapping(_SIGNUP)
@SessionAttributes(FORM)
public class SignUpController {
	
	private final UserService userService;
	private final UserAuthorityService userAuthorityService;
	
	@Autowired
	public SignUpController(UserService userService, UserAuthorityService userAuthorityService) {
		this.userService = userService;
		this.userAuthorityService = userAuthorityService;
	}
	
	@InitBinder(USER_FORM)
	void initBinderUserForm(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
	
	@SuppressWarnings("unused")
	private static final String PUBLIC_KEY = "6LfQth0TAAAAAOWIw1a4oZ3T6DUO8fxP_UfRk_Fs";
	@SuppressWarnings("unused")
	private static final String PRIVATE_KEY = "6LfQth0TAAAAAAeTFAvS9bwc5iiAU5cf7rfrhiN5";
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView begin(Locale locale) {
		return new ModelAndView(SIGNUP).addObject(new UserForm());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	String validate(Locale locale, @Validated UserForm userForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			//TODO to be removed {
			System.out.println("form has " + bindingResult.getErrorCount() + " errors");
			bindingResult.getAllErrors().stream().forEach(System.out::println);
			// }
			userForm.clearPassword();
			return SIGNUP;
		} else {
			userService.create(userForm.createUser(userAuthorityService.findByName(USER)));
			return redirectTo(SIGNIN);
		}
		
	}
}
