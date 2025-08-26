package Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class adacticHotelLogin {
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BADWA03\\eclipse-workspace\\CucumberJava\\Drivers\\chromedriver.exe");
	}
	
	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		
		//enter hotel url
		driver.get("https://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
		//inspect and enter username 
		/*driver.findElement(By.id("username")).sendKeys("vengat16");
		String s = driver.findElement(By.id("username")).getAttribute("value");
		
		//inspect and enter password
		driver.findElement(By.name("password")).sendKeys("Karthick");
	    String s1 = driver.findElement(By.name("password")).getAttribute("value");
	    
	    System.out.println(s);
	    System.out.println(s1);*/
	    
	    boolean logo = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/img[@src='img/AdactIn_logo.png']")).isDisplayed();
	    
	    if(logo==true)
	    {
	    	System.out.println("logo is available");
	    }
	    else 
	    {
	    	System.out.println("logo is not available");
	    }
	    
	    
	    
	    boolean logo1 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/img[@src='img/AdactIn_logo.png']")).isEnabled();
	    
	    if(logo1==true)
	    {
	    	
	    	System.out.println("Text is enable to print");
	    	}
	    else
	    	{
	    	System.out.println("not enable");
	    	}
	    
	    driver.close();
	}
}
	    	
	    	
	    	//driver.findElement(By.id("login")).click();
		
		//Click on Forgot password link
		
		//driver.findElement(By.linkText("Forgot Password?")).click();
		
		//come back to login page.
		//driver.findElement(By.linkText("Go back to Login page")).click();*/
		
	
	
