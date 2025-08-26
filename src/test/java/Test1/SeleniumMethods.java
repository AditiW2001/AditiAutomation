package Test1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {

	public static void main(String[] args) throws InterruptedException {

      WebDriver driver = new ChromeDriver();
    
      //get methods
      
      //get(url)
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
      
      //getTitle()
      System.out.println(driver.getTitle());
      
      //getCurrentUrl()
      System.out.println(driver.getCurrentUrl());
      
      //getPageSource()
      System.out.println(driver.getPageSource());
      
      //getWindowHandle()
      System.out.println(driver.getWindowHandle());
      
      driver.manage().window().maximize();
      Thread.sleep(5000);
      driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
      
      //getWindowHandles()
      Set<String> windowIds = driver.getWindowHandles();
      System.out.println("windowIds are:"+windowIds);
	}
	

}
