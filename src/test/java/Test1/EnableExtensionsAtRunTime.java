package Test1;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionsAtRunTime {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		
		File file = new File("C:\\Users\\BADWA03\\Downloads\\TestAutomation\\Crx files\\SelectorsHub-Chrome-Web-Store.crx");
	       
        options.addExtensions(file); 
		
		WebDriver driver =  new ChromeDriver(options);

		driver.get("https://text-compare.com/");

		System.out.println("Title:"+driver.getTitle());
	
	

	}

}
