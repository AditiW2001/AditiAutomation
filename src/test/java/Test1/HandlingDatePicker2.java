package Test1;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDatePicker2 {
    
	//user defined method for converting month from string ---> Month Object
	static Month convertMonth(String month) {
		HashMap<String, Month> monthMap = new HashMap<String, Month>();
		
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);
		
		Month vmonth = monthMap.get(month);
		
		if(vmonth == null)
		{
			System.out.println("Invalid month.....");
		}
		
		return vmonth;
	}
	
	static void selectDate(WebDriver driver, String requiredyear, String requiredmonth, String requireddate) {

	    // Wait for the dropdowns to be available
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='ui-datepicker-year']")));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='ui-datepicker-month']")));

	    // Select year
	    WebElement yearDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
	    Select selectYear = new Select(yearDropDown);
	    selectYear.selectByVisibleText(requiredyear);

	    // Select month
	    WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
	    Select selectMonth = new Select(monthDropdown);
	    //selectMonth.selectByVisibleText(requiredmonth);
	    
	    String displaymonth = driver.findElement(By.cssSelector("select[aria-label='Select month'] option[value='4']")).getText();
	    System.out.println(displaymonth);

	    Month expectedMonth = convertMonth(requiredmonth);
	    Month currentMonth = convertMonth(displaymonth);

	    int result = expectedMonth.compareTo(currentMonth);

	    if (result < 0) 
	    {
	        driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
	    } else if (result > 0)
	    {
	        driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	    } 
	    
	    // Print available month values (optional debug)
	   /* List<WebElement> monthOptions = selectMonth.getOptions();
	    for (WebElement option : monthOptions) {
	        System.out.println("Month dropdown value: " + option.getText());
	    }

	    selectMonth.selectByVisibleText(requiredmonth.trim());*/

	    // Select date
	    List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
	    for (WebElement dt : allDates) {
	        if (dt.getText().equals(requireddate)) {
	            dt.click();
	            break;
	        }
	    }
	}
	
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		String requiredyear = "2026";
		String requiredmonth = "April";
		String requireddate = "20";
		
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		selectDate(driver,requiredyear,requiredmonth,requireddate);
		
		 
	}
	}
	 



