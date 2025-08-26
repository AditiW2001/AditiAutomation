package Test1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//1) Normal alret with OK button
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		/*driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Alert alertwin = driver.switchTo().alert();
		System.out.println(alertwin.getText());
		alertwin.accept();
		*/
		
		//2)Confirmation Alert  with OK and Cancel button
		/*driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Alert ConfirmAlert = driver.switchTo().alert();
		//ConfirmAlert.accept();
		ConfirmAlert.dismiss();
	    */
		
		//3)Prompt alert - Input box
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		
		Alert Prompt = driver.switchTo().alert();
		Prompt.sendKeys("welcome");
		Prompt.accept();

	} 

}
