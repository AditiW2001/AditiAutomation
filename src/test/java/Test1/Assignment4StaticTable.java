package Test1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4StaticTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@type='submit']")).click();


		//read all rows and columns from the table
		List<WebElement> data = driver.findElements(By.xpath("//table[@class='table']//tbody//tr"));

		for(WebElement tabledata:data) 
		{
			System.out.print(tabledata.getText()+"\t");
			System.out.println();
		}

		// 1. Capture the prices as Strings
		List<WebElement> arr = driver.findElements(By.xpath("//table[@class='table']//tbody//tr//td[6]"));
		String prices[] = new String[arr.size()];

		// 2. Extract text and store in String array
		for(int i = 0;i<arr.size();i++)
		{
			prices[i]= arr.get(i).getText().replaceAll("[^\\d.]", "");
		}

		Arrays.sort(prices);
		System.out.println(Arrays.toString(prices));

		String lowestPrice = prices[0];
		System.out.println("Lowest price: " + lowestPrice);

		// 3. Convert to a Double array for sorting
		//Double[] pricesNumbers = new Double[prices.length];
		//for (int i = 0; i < prices.length; i++) 
		//{
		//  pricesNumbers[i] = Double.parseDouble(prices[i]);
		//}


		// 5. Now find and click the button in the row with that lowest price
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr"));
		for (WebElement row : rows) {
			try {
				WebElement priceCell = row.findElement(By.xpath(".//td[6]"));
				String priceText = priceCell.getText().replaceAll("[^\\d.]", "");
				double price = Double.parseDouble(priceText);

				if (price == Double.parseDouble(lowestPrice))
				{
					WebElement button = row.findElement(By.xpath(".//td[1]//input[@type='submit']"));
					button.click();
					System.out.println("Button clicked");
					break; // Exit loop after clicking
				}
			} catch (org.openqa.selenium.StaleElementReferenceException e) {
				System.out.println("Stale element encountered. Retrying...");
				// Optionally, re-find rows and repeat
			}
		}

		Thread.sleep(5000);
		driver.findElement(By.id("inputName")).sendKeys("Aditi");
		driver.findElement(By.id("address")).sendKeys("ABC Road");
		driver.findElement(By.id("city")).sendKeys("Paris");
		driver.findElement(By.id("state")).sendKeys("State");
		driver.findElement(By.id("zipCode")).sendKeys("123456");
		driver.findElement(By.id("creditCardNumber")).sendKeys("CC123456");
		driver.findElement(By.id("nameOnCard")).sendKeys("MasterCard");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

		Boolean successmsg = driver.findElement(By.xpath("//body//div//h1")).isDisplayed();
		System.out.println(successmsg);
		if(successmsg.equals(true))
		{
			System.out.println(driver.findElement(By.xpath("//body//div//h1")).getText());
		}
	}
}
