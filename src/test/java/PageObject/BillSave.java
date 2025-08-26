package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v116.browser.Browser.GetWindowForTargetResponse;
import org.openqa.selenium.devtools.v116.page.Page.NavigateResponse;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillSave {

	WebDriver ldriver;
	
	public BillSave(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//input[@id=\"search-input\"]")
	WebElement ClickMenus;
	
	@FindBy(xpath="//input[@id=\"search-input\"]")
	WebElement SearchPOSMenu;
	
	@FindBy(xpath="//a[@id=\"pos_anchor\"]")
	WebElement SelectPOSMenu;
	
	@FindBy(xpath="//*[@id=\"counter_selection_modal\"]/div[5]/div[2]/div[2]/div[1]/div/p")
	WebElement SelectCompany;
	
	@FindBy(xpath="//input[@placeholder=\"Search Store\"]")
	WebElement SearchStore;
	
	@FindBy(xpath="/html/body/div[1]/app-root/div/div[3]/div/app-counter-selection/div/div[5]/div[2]/div[2]/div[3]/div/div/div/div")
	WebElement SelectStore;
	
	@FindBy(xpath="//div[@class='card-box card-box-active']//div//div[@class='Second_div2']")
	WebElement SelectCounter;
	
	@FindBy(xpath="//*[@id=\"currencySection\"]/div[2]/div[1]/div[1]/div/div[3]/span[2]/input")
	WebElement ClickDenomination;
	
	@FindBy(xpath="//button[normalize-space()='Begin Shift']")
	WebElement ShiftBegin;
	
	@FindBy(xpath="//button[normalize-space()='Yes']")
	WebElement YesBeginShift;
	
	@FindBy(xpath="//*[@id=\"left\"]/div[2]/app-sell-actions/div[1]/div/div[2]/div[3]/div")
	WebElement Checkout;
	
	@FindBy(xpath="//p[@class='payment-text'][normalize-space()='Cash']")
	WebElement Payment;
	
	@FindBy(xpath="//*[@id=\"Payment_modes_modal\"]/div/div/div[2]/div/div/div[2]/button[2]")
	WebElement Accept;
	
	@FindBy(xpath="//*[@id=\"left\"]/div[2]/app-checkout-sell/div[2]/app-sell-actions/div[1]/div/div[2]/div[3]/div")
	WebElement Submit;
	
	@FindBy(xpath="//*[@id=\"left\"]/div[2]/app-sell-actions/div[1]/div/div[2]/div[3]/div")
	WebElement Save;
	
	
//Create Action Method
	
	public void clickMenus()
	{
		ClickMenus.click();
	}
	
	public void searchMenu()
	{
	    SearchPOSMenu.sendKeys("POS");	
	}
	
	public void selectPOSMenu()
	{
		SelectPOSMenu.click();
	}
	
	public void selectCompany()
	{
		SelectCompany.click();
	}
	
	public void searchStore()
	{
		SearchStore.sendKeys("SG05");	
	}
	
	public void selectStore()
	{
	    SelectStore.click();	
	}
	
	public void SelectCounter()
	{
		SelectCounter.click();
	}
	
	public void ClickDenomination()
	{
		ClickDenomination.sendKeys("10");	
	}
	
	public void ShiftBegin()
	{
		ShiftBegin.click();	
	}
	
	public void YesBeginShift()
	{
		YesBeginShift.click();	
	}
	
	public void ClickOnCheckout()
	{
		Checkout.click();
	}
	
	public void ClicksOnPayment()
	{
		Payment.click();
	}
	
	public void AcceptPayment()
	{
		Accept.click();
	}
	
	public void ClicksOnSubmit()
	{
		Submit.click();
	}
	
	public void ClickOnSave()
	{
		Save.click();
	}
}
