package Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		//isDisplayed()---will check if the element is displayed or not
		
		boolean logo =driver.findElement(By.cssSelector("img[alt='nopCommerce demo store']")).isDisplayed();
		System.out.println("logo displayed status:"+" "+logo);
		
	    //isEnabled
		boolean field = driver.findElement(By.id("FirstName")).isEnabled();
		System.out.println("field enabled status:"+" "+field);
		
		//boolean radiobutton = driver.findElement(By.id("gender-male")).isEnabled();
		//System.out.println("radio button is enabled:"+" " +radiobutton);
		
		WebElement male = driver.findElement(By.id("gender-male"));
		System.out.println("male radio before selecting :"+male.isSelected());
		
		driver.findElement(By.id("gender-male")).click();
		
		System.out.println("male radio after selecting :"+male.isSelected());
		
		//isSelected
		boolean checkbox = driver.findElement(By.id("Newsletter")).isSelected();
		System.out.println("checkbox is selected:"+" " +checkbox);
		
		

	}

}
