package Test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalMethods {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com");
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth.login");
	    
	    driver.navigate().back();
	    System.out.println(driver.getCurrentUrl());
	    
	    driver.navigate().forward();
	    System.out.println(driver.getCurrentUrl());
	    
	    driver.navigate().refresh();
		

	}

}
