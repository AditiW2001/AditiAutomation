package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		driver.switchTo().frame("iframeResult");
		
	    WebElement box1	= driver.findElement(By.xpath("//input[@id='field1']"));
	    WebElement box2	= driver.findElement(By.xpath("//input[@id='field2']"));
	    WebElement button =driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
	    
	    box1.clear();
	    box1.sendKeys("Welcome");
	    
	    //double click on button
	    
	    act.doubleClick(button).build().perform();
	    
	    //validation
	    String expected = box1.getAttribute("value");
	    
	    if(expected.equals("Welcome"))
	    {
	    	System.out.println("Text copied");
	    }
	    else
	    {
	    	System.out.println("Text is not copied");
	    }
	}

}
