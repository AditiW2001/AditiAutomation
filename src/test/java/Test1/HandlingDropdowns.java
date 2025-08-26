package Test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdowns {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		
		Select countryobj = new Select(country);
		
		//1-->SELECT DROPDOWN   -- having select tag in html defines a dropdown is a select dropdown.
		//1)select option from the dropdown
		
		//a)selectByVisibleText()
		//b)selectByValue()
		//c)selectByIndex()
		//countryobj.selectByVisibleText("India");  //visible text starts with upper case
		//countryobj.selectByValue("brazil");  //value starts with lower case
		//countryobj.selectByIndex(1); 
		
		//capture options from the dropdown
		List<WebElement> options = countryobj.getOptions();
		//getOptions - returns all the options from the dropdown as a WebElement and belongs to select class objects only.
	    System.out.println(options.size());
	    
	    //printing the options using classic for loop
	    /*for(int i =0; i<options.size();i++) 
	    {
	    	System.out.println(options.get(i).getText());
	    }
	    */
	    //using enhanced for loop
	    for(WebElement option:options)
	    {
	    	System.out.println(option.getText());
	    }
	    
	    
	}

}
