package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageLogin {



	WebDriver driver;

	public BasePageLogin(WebDriver driver) //constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize @FindBy elements

	}


	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement username;

	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath ="//button[normalize-space()='Login']")
	WebElement LoginBtn;


	public void enterUserName()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys("Admin");
	}

	public void enterPassword()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys("admin123");
	}

	public void clickOnLogin()
	{
		LoginBtn.click();
	}
}

