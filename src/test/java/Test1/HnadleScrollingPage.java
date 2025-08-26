package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HnadleScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =  new ChromeDriver();
        //ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//1 Scroll down page by pixels
		//js.executeScript("window.scrollBy(0,1500)","");
		//System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//2 Scroll till the element is visible
		//WebElement Text = driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));
		//js.executeScript("arguments[0].scrollIntoView();",Text);
		//System.out.println(js.executeScript("return window.pageYOffset;"));
		
		/*WebElement vote = driver.findElement(By.id("vote-poll-1"));
		js.executeScript("arguments[0].scrollIntoView();",vote);
		Thread.sleep(30);
		vote.click();
		driver.switchTo().alert().accept();
		System.out.println(js.executeScript("return window.pageYOffset;"));*/
		
		//3 Scroll till the end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	    System.out.println(js.executeScript("return window.pageYOffset;"));
	    Thread.sleep(5000);
	    
	    //4 Scroll upto initial position
	  	js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	  	System.out.println(js.executeScript("return window.pageYOffset;"));
	    
	    
		
	}
 
}
