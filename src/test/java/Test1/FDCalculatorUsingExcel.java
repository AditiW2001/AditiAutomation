package Test1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculatorUsingExcel {

	public static void main(String[] args) throws IOException, InterruptedException 
	{

		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();

		//Store path of the files
		String filePath = System.getProperty("user.dir")+"\\TestData\\CalculateData.xlsx";

		//get no of rows from excel
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");

		for (int i=1;i<=rows;i++)
		{
			//read data from excel
			String principle = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String rateofinterest = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String period1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String period2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String frequency = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			String exp_mvvalue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);

			//pass above data into the application

			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofinterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);

			Select drpdown = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			drpdown.selectByVisibleText(period2);

			Select drpdown2 = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			drpdown2.selectByVisibleText(frequency);

			driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();

			//validation
			String act_mvvalue= driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();

			if(Double.parseDouble(exp_mvvalue)==Double.parseDouble(act_mvvalue))
			{
				System.out.println("Test Passed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7,"Passed");
				ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
			}
			else
			{
				System.out.println("Test Failed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7,"Failed");
				ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
			}

			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@class='PL5']")).click();

		}//ending of for loop

		driver.quit();

	}

}
