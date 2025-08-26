package Test1;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingBrokenLinks {

	public static void main(String[] args) {
		
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		//capture all links from website
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total no. of links:"+links.size());
		
		int noofBrokenLinks =0;
		
		for(WebElement link : links)
		{
			String hrefval = link.getAttribute("href");
			
			if(hrefval==null || hrefval.isEmpty())
			{
				System.out.println("href attribute value is empty, not possible to check");
				continue;
			}
			
			//hit url to the the server
			
			try
			{
			URL linkURL = new URL(hrefval);
			HttpURLConnection conn= (HttpURLConnection)linkURL.openConnection(); //opens connection to the server
			conn.connect();  //connect and send request to the server.
			
			if(conn.getResponseCode()>=400)
			{
				System.out.println(hrefval+"===>Broken link");
				noofBrokenLinks++;
			}
			else
			{
				System.out.println(hrefval+"===>Not a Broken Link");
			}
			}
			catch(Exception e)
			{
				
			}
		}
		
            System.out.println("BrokenLinks:"+noofBrokenLinks);
	}

}
