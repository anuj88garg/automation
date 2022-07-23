package com.framework.configuration;

public class customAnnotations extends WebdriverInitialization{

	@interface ParameterizedFuntion{
		
	  int fun() default 1;
	}
}
