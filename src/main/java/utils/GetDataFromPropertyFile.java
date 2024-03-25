package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertyFile {

	
	
	
	public String readFilesFromProperty(String key) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\configFile\\data.properties");
		Properties p = new Properties();
		p.load(fis);
		String val= p.getProperty(key);
		return val;
	}
}
