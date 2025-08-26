package Test1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBrowserWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      WebDriver driver =  new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
      driver.manage().window().maximize();
      
      driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
      
      Set<String>  windowids = driver.getWindowHandles();
      
      //Approach 1
      //convert set into list collection  - we do this as there is no get() in set , but we have in list collection.
      
      //List<String> windowlist = new ArrayList(windowids);
      //String parentid = windowlist.get(0);
      //String childid = windowlist.get(1);
      
     /*driver.switchTo().window(childid);
      System.out.println(driver.getTitle());
      
      driver.switchTo().window(parentid);
      System.out.println(driver.getTitle());*/
      
      
      //Approach 2
      
      for(String windid :windowids)
      {
    	  String title = driver.switchTo().window(windid).getTitle();
    	  if(title.equals("OrangeHRM"));
    	  {
    		  System.out.println(driver.getCurrentUrl());
    	  }
      }
      
	}

}
