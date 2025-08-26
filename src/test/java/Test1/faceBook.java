package Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class faceBook extends Base{

	public static void main(String[] args) {
	
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/r.php");
		
		
		for(int i=1;i<=2;i++) {
			
		String s = driver.findElement(By.xpath("//*[@id='u_0_d_+4']/span[1]/label")).getText();
		
		System.out.println(s);
		
		driver.close();
		}
	}
}
		
	   
	
