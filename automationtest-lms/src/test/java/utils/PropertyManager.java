package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

	private static PropertyManager instance;
	private static final Object lock = new Object();
	private static String propertyFilePath = System.getProperty("user.dir") + "/src/test/java/configs/config.properties";	
	private static String loginUrl;
	private static String environment;
	private static String browser;
	private static String user;
	private static String password;

	//Create a Singleton instance. We need only one instance of Property Manager.
	public static PropertyManager getInstance () {
		if (instance == null) {
			synchronized (lock) {
				instance = new PropertyManager();
				instance.loadData();
			}
		}
		return instance;
	}

	//Get all configuration data and assign to related fields.
	private void loadData() {
		//Declare a properties object
		Properties prop = new Properties();

		//Read configuration.properties file
		try {
			prop.load(new FileInputStream(propertyFilePath));
			//prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
		} catch (IOException e) {

			System.out.println("Configuration properties file cannot be found");

		}

		//Get properties from configuration.properties. Set environment.
		environment = prop.getProperty("environment");

		//Get properties from configuration.properties. Set browser.
		browser = prop.getProperty("browser");

		//Get properties from configuration.properties. Set password.
		password = prop.getProperty("password");

		//Get properties from configuration.properties. Set URL.     
		if(environment.equalsIgnoreCase("staging")) {

			loginUrl = prop.getProperty("loginUrlStaging");

		}else if(environment.equalsIgnoreCase("uat")){

			loginUrl = prop.getProperty("loginUrlUat");

		}else if(environment.equalsIgnoreCase("production")) {
			
			loginUrl = prop.getProperty("loginUrlProduction");
			
		}

		//Get properties from configuration.properties. Set username.
		if(environment.equalsIgnoreCase("staging")) {

			user = prop.getProperty("loginUserStaging");

		}else if(environment.equalsIgnoreCase("uat")){

			user = prop.getProperty("loginUserUAT");

		}else if(environment.equalsIgnoreCase("production")){

			user = prop.getProperty("loginUserProduction");

		}

	}

	public String getEnvironment () {
		return environment;
	}

	public String getBrowser () {
		return browser;
	}

	public String getLoginUrl () {
		return loginUrl;
	}

	public String getUser () {
		return user;
	}

	public String getPassword () {
		return password;
	}
}