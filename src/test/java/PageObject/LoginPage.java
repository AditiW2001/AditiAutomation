package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	
	public LoginPage (WebDriver rDriver)
	{
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id = "txtLoginId")
	WebElement email;
	
	@FindBy(id = "inputPassword")
	WebElement pswd;
	
	@FindBy(id = "btnLogin")
	WebElement LoginButton;
	
	//@FindBy(xpath = "//p[text()=' Sylphy Test']")
    //WebElement Group;
	
	@FindBy(xpath = "(//img[@alt='Card image cap'])[1]")
	WebElement UserProfile;
	
	@FindBy(xpath = "//button[text()=' Logout ']")
	WebElement LogoutButton;
	
	public void enterEmail(String emailAdd)
	{
		email.sendKeys(emailAdd);
		
	}
	
	public void enterPassword(String pwd)
	{
		pswd.sendKeys(pwd);
		
	}
	
	public void clickOnLoginBtn() throws InterruptedException
	{
		LoginButton.click();
		Thread.sleep(10000);
		
	}
	
	/*public void clickOnGroup()
	{
		Group.click();
		
	}*/
	
	public void clickOnUserProfile()
	{
		//UserProfile.click();
		UserProfile.click();
		
	}
	
	public void clickOnLogoutBtn()
	{
		//UserProfile.click();
		LogoutButton.click();
		
	}
	
	
}
