package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IMPLLoginTest {

	public static void main(String[] args) throws InterruptedException {
		
		int i;
		for (i=1;i<=5;i++)
		{

			WebDriver driver = new ChromeDriver();
			//WebDriver driver = new EdgeDriver();
			//WebDriver driver = new FirefoxDriver();
            
			driver.get("https://impl-unify-op.etpgroup.com/");
			driver.findElement(By.id("txtLoginId")).sendKeys("prajwal.madhavi@etpgroup.com");
			driver.findElement(By.id("inputPassword")).sendKeys("Etp@12345");
			driver.findElement(By.id("btnLogin")).click();
			
			/*WebDriverWait Wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			
			Wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("pageloader")));
			
			WebElement avatarImage = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Card image cap']")));
			Thread.sleep(100);
			avatarImage.click();
			Thread.sleep(30);
			driver.findElement(By.xpath("//button[@class='hb-btn-transparent']")).click();
			driver.close();*/


	}
	}
}
