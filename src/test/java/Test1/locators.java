package Test1;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//Locators -
//id,name,LinkText,Partial LinkText, ClassName TagName
//Customized Locators  - CSS Selector and Xpath(Relative and Absolute)

public class locators {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		//using id 
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		//uisng name
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		
		//using classname
		driver.findElement(By.className("submit-button")).click();
		
	   //using linktext used for links
		//driver.findElement(By.linkText("Sauce Labs Backpack")).click();
		
		//using partiallinktext used for links
		//driver.findElement(By.partialLinkText("Sauce Labs")).click();
		
		//Tagname and Class is used to group of web elements.
		
		//using classname
		
		//List<WebElement> Links =driver.findElements(By.className("inventory_item_label"));
		//System.out.println("No of links:"+Links.size());
		
		//using tagname
		List<WebElement> AnchorTags = driver.findElements(By.tagName("a"));
		System.out.println("No of AnchorTags:"+AnchorTags.size());
		
		List<WebElement> Images = driver.findElements(By.tagName("img"));
		System.out.println("No of Images:"+Images.size());
		driver.close();

	}

}
