package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


/*
 1)Open application
 2)Test logo presence
 3)Login
 4)Close
 */


public class OrangeHRMTestNgClass {

	WebDriver driver;

	@Test(priority=1)
	public void openapp() 
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}


	@Test(priority =2)
	void testlogo() throws InterruptedException
	{
		Thread.sleep(3000);
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("logo is displayed:"+status);
	}

	@Test(priority =3)
	void testlogin()
	{
       driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
       driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
       driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	}

	@Test(priority =4)
	void testlogout()
	{
      driver.close();
	}

}
