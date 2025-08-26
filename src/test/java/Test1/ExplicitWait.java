package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
       
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")));
        link.click();
        
        driver.close();
	}

}
