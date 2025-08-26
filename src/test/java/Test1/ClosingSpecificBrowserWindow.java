package Test1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSpecificBrowserWindow {

	public static void main(String[] args) {
		
		WebDriver driver =  new ChromeDriver();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	      
	      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	      driver.manage().window().maximize();
	      
	      driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
	      
	      Set<String> windowids = driver.getWindowHandles();
	      
	      for(String win:windowids)
	      {
	    	  String title = driver.switchTo().window(win).getTitle();
	    	  System.out.println(title);
	    	  if(title.equals("Human Resources Management Software | OrangeHRM HR Software"))
	    	  {
	    		  driver.close();
	    	  }  
	      }
	      

	}

}
