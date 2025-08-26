package Test1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.opencart.com/");
		
		//driver.switchTo().newWindow(WindowType.TAB);   //switches to another tab in same window
		
		driver.switchTo().newWindow(WindowType.WINDOW);  //switches to seperate browser window
		
		driver.get("https://opensource-demo.orangehrm.com");
		
		
	}

}
