package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PrpertiyFilePractice {

	public static void main(String[] args) throws IOException {
		
		//Step1: Open the file in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommanData.propertie");
		
		//step2: create object of properties from java.util.pacakage
		Properties pobj = new Properties();
		
		//step3: load the file input stream input properties
		pobj.load(fis);
		
		//Step4:access the file values with keys
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		String BROWSER = pobj.getProperty("browser");
		
		//Step5: for output
		
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		System.out.println(BROWSER);
	}

}
