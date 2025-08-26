package Test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAutoSuggestDropdown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("APjFqb")).sendKeys("selenium");
		
        List<WebElement> option = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		
        System.out.println(option.size());
        
        for(int i = 0;i<option.size();i++)
        {
        	System.out.println(option.get(i).getText());
        	if(option.get(i).getText().equals("selenium"))
        	{
        		option.get(i).click();
        		break;
        	}
        		
        }

	}

}
