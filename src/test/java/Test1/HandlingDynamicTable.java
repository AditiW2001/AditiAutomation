package Test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicTable {

	
	//select future dates
	static void selectFutureDate(WebDriver driver, String month, String year, String date)
	{
		//select month & year
		//actual data
		while(true)
		{
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText(); //actual month
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(); //actual year
			if(currentMonth.equals(month) && currentYear.equals(year))
			{
				break;
			}

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //click on next arrow
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();  //click on previous arrow
		}
		//select the date
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
	}
	
	//select past dates
	static void selectPastDate(WebDriver driver, String month, String year, String date)
	{
		//select month & year
		//actual data
		while(true)
		{
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText(); //actual month
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(); //actual year

			if(currentMonth.equals(month) && currentYear.equals(year))
			{
				break;
			}

			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //click on next arrow
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();  //click on previous arrow
		}
		//select the date
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
	}

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		//switch to frame
		driver.switchTo().frame(0);

		//Method1: Using sendkeys()
		driver.findElement(By.id("datepicker")).sendKeys("05/24/2025");  //mm-dd-yyyy

		//Method2 : Using Datepicker element
		//expected data
		String year = "2026";
		String month = "May";
		String date = "15";

		driver.findElement(By.id("datepicker")).click();
        
		
		//call the methods based on the past or future dates
        selectFutureDate(driver,month,year,date);
       //selectPastDate(driver,month,year,date);

		
	}

}
