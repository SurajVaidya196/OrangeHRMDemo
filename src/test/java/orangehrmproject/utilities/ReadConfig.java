package orangehrmproject.utilities;

import java.io.*;
import java.util.Properties;

public class ReadConfig {

	static Properties pro;
	public ReadConfig(){
		File path=new File("./Configuration/config.properties");
		//String path="./Configuration/config.properties";
		try {
			FileInputStream inst=new FileInputStream(path);
			pro=new Properties();
			pro.load(inst);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public   String getBaseUrl() {
		String burl=pro.getProperty("baseUrl");
		return burl;
	}
	public  String getUsername() {
		String username=pro.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password=pro.getProperty("password");
		return password;
	}
	public static String getXlPath()
	{
		String xlpath=pro.getProperty("XLSheetPath");
		return xlpath;
	}
}
