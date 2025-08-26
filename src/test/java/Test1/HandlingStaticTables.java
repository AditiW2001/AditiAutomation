package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingStaticTables {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		//1)find total no. of rows in a table
		int rows = driver.findElements(By.xpath("//table[@ name='BookTable']//tr")).size();
		//int rows=  driver.findElements(By.tagName("tr")).size();
		//System.out.println("Total No.of rows:"+rows);  //7 rows
/*
		//2)find total no. of columns in a table
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Total No.of columns:"+cols); 


		//3)read data from specific row and column 5th row and 1st column
		String bookname = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();
		System.out.println("Bookname at 5th row and 1st column is:"+bookname);

		//4)read data from all the rows and columns
        System.out.println("Bookname"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
		for(int r=2;r<=rows;r++)
		{
			for(int c=1;c<=cols;c++)
			{
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td["+c+"]")).getText();
				System.out.print(value+"\t");
			}
			System.out.println();
		}*/
		
		//conditional based - Print booknames who's author is mukesh
		/*for(int r=2;r<=rows;r++)
		{
			String Author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			
			if(Author.equals("Animesh"))
			{
				String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println("Books written by author Mukesh:"+bookName);
			}
		}
		*/
		int total = 0;
		for(int r=2;r<=rows;r++)
		{
			
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			total = total + Integer.parseInt(price);	
	}
		System.out.println("Total price of the books:"+total);  //7100
	}
}
