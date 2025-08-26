package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewUser {

	public WebDriver ldriver;
	
	//constructor
	public CreateNewUser(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//input[@class='form-control searchClass form-placeholder ng-pristine ng-valid ng-touched']")
	WebElement SearchMenu;
	
	@FindBy(xpath ="//span[normalize-space()='ADMINISTRATION']")
	WebElement Menu;
	
	@FindBy(xpath = "//a[normalize-space()='User Management']")
	WebElement SubMenu;
	
	@FindBy(xpath = "//button[@class='hb-add-icon-btn']")
	WebElement PlusBtn;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement Username;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement Useremail;
	
	@FindBy(xpath = "//mat-select[@id='select1']//div[@class='mat-select-value']")
	WebElement ISOcode;
	
	@FindBy(xpath = "//span[@class='mat-option-text'][normalize-space()='91 - India']")
	WebElement Code;
	
	@FindBy(xpath = "//input[@id='usr']")
	WebElement MobileNumber;
	
	@FindBy(xpath = "//span[@class='user-cre-all-access-txt user-cre-enable-access-icon']")
	WebElement Allaccessbtn;
	
	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement SaveBtn;
	
////////////Action Methods/////////////////////////
	
	public void clickOnSearchMenu()
	{
	     SearchMenu.click();	     
	}
	
	public void clickOnAdminstrationMenu()
	{
	     Menu.click();
	}
	
	public void clickOnUserManagementSubmenu()
	{
	     SubMenu.click();	     
	}
	
	public void clickOnPlusBtn()
	{
	     PlusBtn.click();
	}
	
	public void enterUserName(String name)
	{
	     Username.sendKeys(name);;
	}

	public void enterEmailId(String email)
	{
		Useremail.sendKeys(email);
	}
	
	public void clickOnISOCode()
	{
		ISOcode.click();
	}
	
	public void selectISOCode()
	{
		Code.click();
	}
	
	public void enterMobileNumber(String number)
	{
		MobileNumber.sendKeys(number);
	}
	
	public void clickOnAllAcessBtn()
	{
		Allaccessbtn.click();
	}
	
	public void clickOnSaveBtn()
	{
		SaveBtn.click();
	}
}
