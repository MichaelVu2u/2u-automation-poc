package configs;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import createtestdata.CreateAdditionalTextPages;

public class PropertiesFile {

	public static void main(String[] args) {
		getProperites();
	}
	
	public static void getProperites() {

		try {
			
			Properties prop = new Properties();
			
			String projectPath = System.getProperty("user.dir");
			
			InputStream input = new FileInputStream(projectPath + "/src/test/java/configs/config.properties");
			prop.load(input);
			
			String browser = prop.getProperty("browser");
			System.out.println("Test browser is " + browser);
			CreateAdditionalTextPages.browserName=browser;
			
			String loginUATurl = prop.getProperty("loginUATurl");
			CreateAdditionalTextPages.loginUATurl = loginUATurl;
			
			String loginstagingurl = prop.getProperty("loginstagingurl");
			CreateAdditionalTextPages.loginstagingurl = loginstagingurl;
			
			String UATcourseWorkEditUrl = prop.getProperty("UATcourseWorkEditUrl");
			CreateAdditionalTextPages.UATcourseWorkEditUrl = UATcourseWorkEditUrl;
			
			String stagingcourseWorkEditUrl = prop.getProperty("stagingcourseWorkEditUrl");
			CreateAdditionalTextPages.stagingcourseWorkEditUrl = stagingcourseWorkEditUrl;
			
			String loginUserUAT = prop.getProperty("loginUATuser");
			CreateAdditionalTextPages.loginUATuser = loginUserUAT;
			
			String loginstaginguser = prop.getProperty("loginstaginguser");
			CreateAdditionalTextPages.loginstaginguser = loginstaginguser;
			
			String password = prop.getProperty("password");
			CreateAdditionalTextPages.password = password;
			
			String environment = prop.getProperty("environment");
			CreateAdditionalTextPages.environment = environment;
		}
		catch(Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}
