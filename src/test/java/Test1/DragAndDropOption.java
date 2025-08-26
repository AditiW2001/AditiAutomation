package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropOption {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		WebElement rome = driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement italy = driver.findElement(By.xpath("//div[@id='box106']"));
		act.dragAndDrop(rome,italy).perform();
		
		WebElement Oslo = driver.findElement(By.xpath("//div[@id='box1']"));
		WebElement Spain = driver.findElement(By.xpath("//div[@id='box107']"));
		act.dragAndDrop(Oslo,Spain).perform();
		
		WebElement Washington = driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement UnitedStated = driver.findElement(By.xpath("//div[@id='box103']"));
		act.dragAndDrop(Washington,UnitedStated).perform();
		
		WebElement Rome = driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement Main = driver.findElement(By.xpath("//div[@id='capitals']"));
		act.dragAndDrop(Rome,Main).perform();
		
		WebElement oslo = driver.findElement(By.xpath("//div[@id='box1']"));
		WebElement Main1 = driver.findElement(By.xpath("//div[@id='capitals']"));
		act.dragAndDrop(oslo,Main1).perform();
		
		WebElement washington = driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement Main2 = driver.findElement(By.xpath("//div[@id='capitals']"));
		act.dragAndDrop(washington,Main2).perform();

	}

}
