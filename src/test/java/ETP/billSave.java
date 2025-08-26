package ETP;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class billSave {

	static {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BADWA03\\eclipse-workspace\\CucumberJava\\Drivers\\chromedriver.exe");
	}
	
	public static void main(String[] args) {
	
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://test-unify.etpgroup.sg/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtLoginId")).sendKeys("egs.enterprise@etpgroup.com");
		
		driver.findElement(By.id("inputPassword")).sendKeys("Egs@1310");
		
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.className("imgCenter ng-star-inserted"));
		
		driver.findElement(By.className("hb-btn-transparent"));
				
	    

	}

}
