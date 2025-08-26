package Test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//td/input[@type='checkbox' and @data-has-listeners='true']"));
        
		for(WebElement boxes : checkboxes)
		{
			js.executeScript("arguments[0].scrollIntoView(true);", boxes);
			 Thread.sleep(300);
			boxes.click();
		}
	}
	

}
