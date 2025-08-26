package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
		
		//Find total no.of links
		/*List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total No of Links:"+Links.size());
		for(WebElement link : Links)
		{
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
			 System.out.println("---------------------"); 
		}*/
		
		/*List<WebElement> images= driver.findElements(By.tagName("img"));
         System.out.println("No of Images:"+images.size());	
         for(WebElement image : images)
 		{
 			System.out.println(image.getAttribute("src"));
 			 System.out.println("---------------------"); 
 		}*/
		
		
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);"); // Scroll more if needed

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Wait until the element is clickable BEFORE finding it
		WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Samsung galaxy s6")));

		product.click();*/

		//Using css selector (tag#id) 
		boolean logo = driver.findElement(By.cssSelector("a#nava")).isDisplayed();
		System.out.println(logo);
		
		//using css selector (tag.classname[attribute='value'])
		
		driver.findElement(By.cssSelector("a.nav-link[href='#']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#recipient-email")));
		driver.findElement(By.cssSelector("#recipient-email")).sendKeys("Test@gmail.com");
		
		//using css selector   tag#id
		driver.findElement(By.cssSelector("input#recipient-name")).sendKeys("Test");
		
		//using css selector   tag[attribute='value']
		driver.findElement(By.cssSelector("textarea[id='message-text'")).sendKeys("Welcome to Demo  Blaze, Happy Learning");
		
		//using css selector   tag.class[attribue='value']
		//driver.findElement(By.cssSelector("button.btn[type='button']")).click();
		
		
		
		
	}

}
