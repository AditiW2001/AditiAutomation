package Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssselectorlocator {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nopcommerce.com/en/demo?srsltid=AfmBOopj6lWdNtSXRAkhKewOEzqn-aYfj8f0d_7HNg4YVelQgH9GfuQF");
		driver.manage().window().maximize();
		
		//using css selector (tag.classname)
		//driver.findElement(By.cssSelector("svg.navigation-shopping-cart-ico")).click();
		
		//using css selector (tag[attribute='value'])
		driver.findElement(By.cssSelector("a[href='/en/get-started']")).click();
		
		//using css selector (tag.classname[attribute='value'])
		//check in Assignment.java have done there.

	}

}
