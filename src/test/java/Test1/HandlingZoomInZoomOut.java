package Test1;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingZoomInZoomOut {

	public static void main(String[] args) {
		WebDriver driver =  new ChromeDriver();
        //ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='50%'");   //set zoom level 50%
		js.executeScript("document.body.style.zoom='80%'");   //set zoom level 50%

		
	}

}
