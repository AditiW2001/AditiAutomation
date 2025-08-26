package Test1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless6");  //setting for headless mode of execution

		 
		WebDriver driver =  new ChromeDriver(options);
		
		driver.get("https://demo.nopcommerce.com/");
		//validate the title
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals("nopCommerce demo store. Home page title"))
		{
			System.out.println("Test Passed");
		}
		else 
		{
			System.out.println("Test Failed");
		}
		
		driver.close();
		driver.quit();
	}
	

}
