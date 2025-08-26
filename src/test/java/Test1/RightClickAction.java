package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		WebElement rightclick =driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		//Right click action
		act.contextClick(rightclick).build().perform();
		
		//click on copy from context menu
		driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
		
		//close alert box
		driver.switchTo().alert().accept();
	}

}
