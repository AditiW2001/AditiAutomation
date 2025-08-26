package Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


//Parameterization 

//@DataProvider  --data driven testing
//using xml file --parallel testing

public class ParametrizationDataProviderandParallelTestingTestNG {
	
	WebDriver driver;

    @BeforeClass
	public void setup()
	{
    	driver = new ChromeDriver();
    	
	}
    
    @Test
    public void testLogin()
    {
    	driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
    	driver.manage().window().maximize();
    	driver.findElement(By.id("input-email")).sendKeys("abc@gmail.com");
    	driver.findElement(By.id("input-password")).sendKeys("pwd");
    	driver.findElement(By.xpath("//input[@value='Login']")).click();
    	
    }
    
    @AfterClass
    public void tearDown()
    {
    	
    }
	
	}


