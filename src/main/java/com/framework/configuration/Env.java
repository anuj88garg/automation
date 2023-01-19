package com.framework.configuration;

public class Env {

	public static String getEnvProperty(String key) {
		return System.getProperty(key);
	}
	
	public static String setEnvProperty(String key, String val) {
		return System.setProperty(key, val);
	}
}
