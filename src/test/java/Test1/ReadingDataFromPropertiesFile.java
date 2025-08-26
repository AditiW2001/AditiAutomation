package Test1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
	
	//create object of properties file
	Properties obj = new Properties();
	
    //location of properties file
	FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\config.properties");

	//loading properties file
	obj.load(file);
	
	//reading data from properties file
	
	String url = obj.getProperty("appurl");
	String email = obj.getProperty("email");
	String pswd = obj.getProperty("password");
	String ordid = obj.getProperty("orderid");
	String custid  = obj.getProperty("customerid");
	
	System.out.println(url +" "+email+" "+pswd+" "+ordid+" "+custid);


	
	}

}
