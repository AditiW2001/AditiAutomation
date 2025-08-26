package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestLogin {

	public static void main(String[] args) throws InterruptedException {

		int i;
		for (i=1;i<=10;i++)
		{

			//WebDriver driver = new ChromeDriver();
			//WebDriver driver = new EdgeDriver();
			WebDriver driver = new FirefoxDriver();
            
			driver.get("https://test-unify.etpgroup.sg/");
			driver.findElement(By.id("txtLoginId")).sendKeys("egs.enterprise@etpgroup.com");
			driver.findElement(By.id("inputPassword")).sendKeys("Egs@1612");
			driver.findElement(By.id("btnLogin")).click();
			WebDriverWait Wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			
			Wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("pageloader")));
			
			WebElement avatarImage = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://test-unify-gw.etpgroup.sg/default/thanatos/1.0/iiif/2/702ecaa9f9ecb28e64046b20203148ac./full/full/0/default.jpg-C1mF03NDErcyAeCUT0Qu6tEIfGbwunjNzaeQSdvasQw/mm5rIBtB4aCTB2mDiDe25HO/3fEU0p8btM7V90fusW/RgZbz6xBW0QBYUOEnd1Mio/5/9TKvPcaULXS41tXoiI+nO0Gvfiq91nwpXaYvrA66VgrSAUf+NThw6c0wpKE=']")));
			Thread.sleep(100);
			avatarImage.click();
			Thread.sleep(30);
			driver.findElement(By.xpath("//button[@class='hb-btn-transparent']")).click();
			driver.close();

		
		}
	}
}
