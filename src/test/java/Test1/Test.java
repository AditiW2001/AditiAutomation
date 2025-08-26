package Test1;

import java.util.Scanner;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BADWA03\\eclipse-workspace\\CucumberJava\\Drivers\\chromedriver.exe");
	}
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		        
		        //enter the url
				driver.get("https://www.gmail.com");
			
				//delete cookies
				driver.manage().deleteAllCookies();
				
				//set the size of window
				Dimension d = new Dimension(500,500);
				driver.manage().window().setSize(d);
				
				//set position of the window
				Point p = new Point(250,250);
				driver.manage().window().setPosition(p);
				
				//manage and maximize the window
				driver.manage().window().maximize();
				
				
				//get the title of current web page
				String title = driver.getTitle();
				System.out.println("Title:" +title);
				
				//get the URL of Current web page
				String url = driver.getCurrentUrl();
				System.out.println("URL:" +url);
				
				driver.navigate().to("https://www.facebook.com");
				
				driver.navigate().back();
				
				//driver.navigate().forward();
				
				driver.navigate().refresh();
				
				/*String source = driver.getPageSource();
				System.out.println("PageSource:" +source);*/
				
                
			   // driver.close();
			     
		/*Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter browser name:");
		String browser = sc.nextLine();
		
		WebDriver driver = null;
		
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\BADWA03\\eclipse-workspace\\CucumberJava\\Drivers\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.close();
		}
		
		else 
		{
			if(browser.equals("FireFox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\BADWA03\\eclipse-workspace\\CucumberJava\\Drivers\\geckodriver.exe");
				
				driver = new FirefoxDriver();
			} 
			else
			{
				System.out.println("Invalid Browser");
			}
		}*/
		
		
	}

}
