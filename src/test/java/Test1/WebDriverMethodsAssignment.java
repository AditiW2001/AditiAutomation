package Test1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethodsAssignment {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		//get(url)
		driver.get("https://testautomationpractice.blogspot.com/");

		//getTitle
		System.out.println("Title:"+" "+driver.getTitle());

		//getCurrentUrl()
		System.out.println("Url:"+" "+driver.getCurrentUrl());

		//getPageSource()
		System.out.println("PageSource:"+" "+driver.getPageSource());


		//isDisplayed
		boolean  title = driver.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']")).isDisplayed();
		System.out.println(title);

		//isEnabled
		System.out.println(driver.findElement(By.id("name")).isEnabled());

		//IsSelected
		System.out.println("Before selecting:"+" "+driver.findElement(By.id("male")).isSelected());
		Thread.sleep(3000);
		driver.findElement(By.id("male")).click();
		Thread.sleep(3000);
		System.out.println("After selecting:"+" "+driver.findElement(By.id("male")).isSelected());


		//getWindowHandle()
		System.out.println("WindowHandle:"+" "+driver.getWindowHandle());

		//getWindowsHandles()
		driver.findElement(By.xpath("//button[normalize-space()='New Tab']")).click();
		Thread.sleep(3000);
		Set<String> WindowsIds = driver.getWindowHandles();
		System.out.println("WindowHandles:"+" "+WindowsIds);
		
		//close() and quit()
		driver.close();
		driver.quit();
		
	}

}
