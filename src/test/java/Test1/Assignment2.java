package Test1;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		//get(url)
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		List<WebElement> links = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']/a"));

		System.out.println(links.size());

		for(WebElement str : links)
		{

			str.click();
		}

		Set<String> ids= driver.getWindowHandles();
		
		// Define expected titles
        Set<String> expectedTitles = new HashSet<>();
        expectedTitles.add("Selenium - Wikipedia");
        expectedTitles.add("Selenium in biology - Wikipedia");
        expectedTitles.add("Selenium disulfide - Wikipedia");
        expectedTitles.add("Selenium (software) - Wikipedia");
        expectedTitles.add("Selenium dioxide - Wikipedia");
                           
        
		for(String wind:ids)
		{
			String title= driver.switchTo().window(wind).getTitle();
			System.out.println("Titles:"+title);
			//if(title.equals("Selenium - Wikipedia")||title.equals("Selenium in biology - Wikipedia")||title.equals("Selenium disulfide - Wikipedia")||title.equals("Selenium (software) - Wikipedia")||title.equals("Selenium dioxide - Wikipedia"))
			
			if(expectedTitles.contains(title)) 
			{
			System.out.println("Url of matching tab:"+driver.getCurrentUrl());
			driver.close();
		}
		}
	}
}






