package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFileUploads {
	public static void main(String[] args) {
		WebDriver driver =  new ChromeDriver();
        //ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();

		//single file upload
		/*driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\BADWA03\\Downloads\\TestAutomation\\TestSingleUpload.txt");
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("TestSingleUpload.txt"))
		{
			System.out.println("Upload Success");
		}
		else
		{
			System.out.println("Upload Fail");
		}*/
		
		//multiple file uploads
		String file1 = "C:\\\\Users\\\\BADWA03\\\\Downloads\\\\TestAutomation\\\\TestSingleUpload.txt";
		String file2 = "C:\\\\Users\\\\BADWA03\\\\Downloads\\\\TestAutomation\\\\TestSingleUpload1.txt";

        driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		
		int files = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		//no of files validation
		if(files==2)
		{
			System.out.println("All Files Upload Success");
		}
		else
		{
			System.out.println("Files Upload Fail");
		}
		
		//validate file names
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("TestSingleUpload.txt")&& 
				driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("TestSingleUpload1.txt")) 
		{
			System.out.println("All Files name matching");
		}
		else
		{
			System.out.println("All Files name are not matching");

		}
}
}
