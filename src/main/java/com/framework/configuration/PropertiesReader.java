package com.framework.configuration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	 public static String getProperty(String prop) throws IOException {
		 File file = new File(System.getProperty("user.dir")+ "/src/main/resources/Configuration.properties");
		 FileReader reader=new FileReader(file);  
	     Properties p= new Properties(); 
	     p.load(reader);
	     return p.getProperty(prop);
		
	 }

}
