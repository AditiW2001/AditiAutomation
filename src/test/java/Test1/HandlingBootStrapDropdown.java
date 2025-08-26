package Test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBootStrapDropdown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click(); //opens dropdown options
		
		//select single option
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		//capture all options and find the size
		List<WebElement> drpvalue = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));	
		System.out.println(drpvalue.size());
		
		//printing all options 
		/*for(WebElement values: drpvalue)
		{
			System.out.println(values.getText());
		}*/
		
		//select multiple options
		for(WebElement values: drpvalue)
		{
			String option = values.getText();
			if(option.equals("C#") ||option.equals("Python") ||option.equals("MySQL"))
			{
				values.click();
			}
		}
	  
	}
	

}
