package com.github.bugtamer.geolocation.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author https://github.com/bugtamer
 */
public class GoogleMapConfig {
	
	private static GoogleMapConfig singleton;
	private static Properties prop;
	
	
	
	private GoogleMapConfig() throws IOException {
		prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream("googleApiKey.properties");
		prop.load(input);
	}
	
	
	
	public static GoogleMapConfig getInstance() throws IOException {
		return (singleton == null) ? new GoogleMapConfig() : singleton;
	}
	
	
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}

}
