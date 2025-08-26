package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrentProdLogin {

	public static void main(String[] args) throws InterruptedException {
		int i;
		for (i=1;i<=1;i++)
		{

			//WebDriver driver = new ChromeDriver();
			//WebDriver driver = new EdgeDriver();
			WebDriver driver = new FirefoxDriver();
            
			long start = System.currentTimeMillis(); 
			System.out.println("Page Load Time Start: " + start + " milliseconds");
			
			driver.get("https://app-unify-trent.etpgroup.com/");
			driver.findElement(By.id("txtLoginId")).sendKeys("abdul.rahman@etpgroup.com");
			driver.findElement(By.id("inputPassword")).sendKeys("India@123");
			driver.findElement(By.id("btnLogin")).click();
			driver.close();
			
			long finish = System.currentTimeMillis();
			System.out.println("Page Load Time Finish: " + finish + " milliseconds");
			
			long totalTime = finish - start;
			System.out.println("Page Load Time Total: " + totalTime + " milliseconds");
			
			
			WebDriverWait Wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			
			Wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("pageloader")));
			
			//JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement avatarImage = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Card image cap']")));
			avatarImage.click();
			//js.executeScript("arguments[0].click()",avatarImage);
			
			driver.findElement(By.xpath("//button[@class='hb-btn-transparent']")).click();
			driver.close();
	}
	}
}
