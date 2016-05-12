package com.simpleinvoice.util;

public final class InternalResourceResolver {
	private InternalResourceResolver() {}
	
	public static final String ROOT = "";
	public static final String _ROOT = "/";
	public static final String INDEX = "index";
	public static final String _INDEX = ROOT + INDEX;
	public static final String SIGNIN = "signin";
	public static final String _SIGNIN = ROOT + SIGNIN;
	public static final String SIGNUP = "signup";
	public static final String _SIGNUP = ROOT + SIGNUP;
	
	private static final String REDIRECT = "redirect:/";
	
	public static String redirectTo(String target) {
		return REDIRECT + target;
	}

}
