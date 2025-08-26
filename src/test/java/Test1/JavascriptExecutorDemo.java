package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {

	public static void main(String[] args) {
		
		WebDriver driver =  new ChromeDriver();
        //ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement name = driver.findElement(By.id("name"));
		
		//alternate of sendkeys()
		JavascriptExecutor js = (JavascriptExecutor)driver; //upcasting - child class object we are storing in parent class variable.
		//JavascriptExecutor js = driver; // if driver is created directly with chromedriver object no need to do typecasting.
		js.executeScript("arguments[0].setAttribute('value','Aditi')",name);
		
		//alternate of click()
		WebElement button = driver.findElement(By.id("male"));
		js.executeScript("arguments[0].click()",button);
	}

}
