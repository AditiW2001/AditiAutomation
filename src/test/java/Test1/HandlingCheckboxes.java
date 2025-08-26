package Test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckboxes {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Selecting all checkboxes
		
		 List<WebElement> Checkboxes= driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
         
		 //using for each loop
		/* for(WebElement checkbox:Checkboxes)
		 {
			 checkbox.click();
		 }*/
		 
		 //using classic for loop
		 /*for(int i =0; i<Checkboxes.size();i++)
		 {
			 Checkboxes.get(i).click();
		 }*/
		 
		 //select last three checboxes
		 //formula = total no.of checkboxes- checkboxes you want to select = starting index
		 //7-3=4(starting index)
		 /*for (int i=4;i<Checkboxes.size();i++)
		 {
			 Checkboxes.get(i).click();
		 }*/
		 
		 //select first three checkboxes out of 7 checkboxes
		 /*for(int i = 0;i<3;i++)
		 {
			 Checkboxes.get(i).click();
		 }*/
		 
		 //Unselect the checkboxes which are already selected
		 for(int i = 0;i<3;i++) 
		 {
			 Checkboxes.get(i).click();
		 }
		 
		 for(int i=0;i<Checkboxes.size();i++)
		 {
			 if(Checkboxes.get(i).isSelected());
			 {
				 Checkboxes.get(i).click();
			 }
			 
		 }
	}

}
