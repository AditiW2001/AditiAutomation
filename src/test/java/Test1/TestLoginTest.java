package Test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestLoginTest 
{

   WebDriver driver;
   
   @BeforeMethod
   public void setup()
   {
	   driver = new ChromeDriver();
	   driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
   }
   
   @Test
   public void login()
   {
	   BasePageLogin pg = new BasePageLogin(driver);
	   pg.enterUserName();
	   pg.enterPassword();
	   pg.clickOnLogin();
   }
   
   @AfterMethod
   public void tearDown()
   {
	   driver.close();
   }

}


