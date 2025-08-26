package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
        WebElement pointme =driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));
        WebElement laptops = driver.findElement(By.xpath("//a[normalize-space()='Laptops']"));
         
        Actions act = new Actions(driver);
        
        //Mouse hover action 
        //act.moveToElement(pointme).moveToElement(laptops).build().perform();
        act.moveToElement(pointme).moveToElement(laptops).perform();
	}

}
