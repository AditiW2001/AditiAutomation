package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingSliders {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();

        //min slider	
		WebElement min_slider = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		System.out.println("Location of the the min_slider:"+min_slider.getLocation().getX());  //(59,256)

		Actions act = new Actions(driver);
		act.dragAndDropBy(min_slider, 100, 256).perform();
		System.out.println("Location of the the min_slider after moving:"+min_slider.getLocation().getX());  //

		//max slider 
		WebElement max_slider =driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
		System.out.println("Location of the max_slider:"+max_slider.getLocation()); //(510,256)
		
		act.dragAndDropBy(max_slider, -100, 256).perform();
		System.out.println("Location of the the max_slider after moving:"+max_slider.getLocation());  //




	}

}
