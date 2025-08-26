package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.BillSave;
import PageObject.LoginPage;
import PageObject.ScanProducts;
import io.cucumber.datatable.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.WindowHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;


public class BillSaveStepDef{
	
	public WebDriver driver;
	public LoginPage loginPg;
	public BillSave billsave;
	
	
    
	
	@Given("user launches Chrome Browser")
		public void user_launch_chrome_browser() {
		    WebDriverManager.chromedriver().setup();
		    driver  = new ChromeDriver();
		    driver.manage().window().maximize();
		    
		    billsave = new BillSave(driver);
		}
	
	@When("user opens URL")
	public void user_open_url() {
	    driver.get("https://test-unify.etpgroup.sg/");
	}
	
	
	@And("User is logged in")
	public void user_is_logged_in() throws InterruptedException {
	    LoginPage loginPg = new LoginPage(driver);
	    loginPg.enterEmail("egs.enterprise@etpgroup.com");
	    loginPg.enterPassword("Egs@1612");
	    loginPg.clickOnLoginBtn();
	}


	@Given("user clicks on the POS Menu")
	public void user_clicks_on_the_POS_Menu() throws InterruptedException {
      billsave.clickMenus();
      Thread.sleep(2000);
	}
      
      @Given("when user searches the POS Menu")
      public void when_user_searches_the_POS_Menu() throws InterruptedException {
      billsave.searchMenu();
      Thread.sleep(2000);
	}
      
      @Then("Select the POS Menu")
      public void then_selects_the_POS_Menu() throws InterruptedException {
      billsave.selectPOSMenu();
      Thread.sleep(2000);
	}

	@Then("Selects the Company")
	public void selects_the_Company() throws InterruptedException {
		billsave.selectCompany();
		Thread.sleep(2000);
	}
	
	@Then("Searches the Store")
	public void searches_the_Store() throws InterruptedException {
		billsave.searchStore();
		Thread.sleep(2000);
	}
		
	@Then("Selects the Store")
		public void selects_the_Store() throws InterruptedException {
		billsave.selectStore();	
		Thread.sleep(2000);
		}
	    

	@Then("Selects the Counter")
	public void selects_the_Counter() throws InterruptedException {
	   billsave.SelectCounter();
	   Thread.sleep(2000);
	}

	@Then("Enters Denonimation")
	public void enters_Denonimation() throws InterruptedException {
	    billsave.ClickDenomination();
	    Thread.sleep(2000);
	}

	@Then("Begins the Shift")
	public void begins_the_Shift() throws InterruptedException {
	    billsave.ShiftBegin();
	    Thread.sleep(2000);
	    billsave.YesBeginShift();
	    Thread.sleep(2000);
	}
	
	@Then("I close the unwanted popup window")
    public void iCloseTheUnwantedPopupWindow() throws InterruptedException {
		WindowHelper windowHelper = new WindowHelper(driver);
		Thread.sleep(2000);
		windowHelper.closeAllOtherWindowsExceptMain();
		Thread.sleep(2000);
	}
	
	@When("User scans the following products:")
		public void user_scans_the_following_products(DataTable dataTable) throws InterruptedException {
		ScanProducts products = new ScanProducts(driver);
		    List<String> productCodes = dataTable.asList(String.class);
		    products.scanProducts(productCodes);
		}
	

	@Then("User clicks on Checkout")
	public void user_clicks_on_Checkout() throws InterruptedException {
	    billsave.ClickOnCheckout();
	    Thread.sleep(2000);
	    WindowHelper windowHelper = new WindowHelper(driver);
		Thread.sleep(2000);
	    windowHelper.closeAllOtherWindowsExceptMain();
		Thread.sleep(2000);
	}

	@Then("User clicks on Payment Window")
	public void user_clicks_on_Payment_Window() throws InterruptedException {
	    billsave.ClicksOnPayment();
	    Thread.sleep(2000);
	}
	
	@Then ("Accepts the Payment")
	public void accepts_the_payment() throws InterruptedException{
		billsave.AcceptPayment();
		Thread.sleep(2000);
	}

	@Then("User clicks on Submit Button")
	public void user_clicks_on_Submit_Button() throws InterruptedException {
	   billsave.ClicksOnSubmit();
	   Thread.sleep(2000);
	}

	@Then("User clicks on Save Button.")
	public void user_clicks_on_Save_Button() throws InterruptedException {
	    billsave.ClickOnSave();
	    Thread.sleep(2000);
	}
	
	@Then("user saves the bill twice with following products:")
	public void user_saves_the_bill_twice_with_following_products(DataTable dataTable) throws InterruptedException {
	    for (int i = 1; i <= 2; i++) {
	        System.out.println("🧾 Saving bill: Run #" + i);
	        saveBillOnce(dataTable);
	    }
	}
	
	public void saveBillOnce(DataTable dataTable) throws InterruptedException {
	    ScanProducts products = new ScanProducts(driver);
	    List<String> productCodes = dataTable.asList(String.class);
	    products.scanProducts(productCodes);

	    billsave.ClickOnCheckout();
	    Thread.sleep(2000);

	    WindowHelper windowHelper = new WindowHelper(driver);
	    Thread.sleep(2000);
	    windowHelper.closeAllOtherWindowsExceptMain();
	    Thread.sleep(2000);

	    billsave.ClicksOnPayment();
	    Thread.sleep(2000);

	    billsave.AcceptPayment();
	    Thread.sleep(2000);

	    billsave.ClicksOnSubmit();
	    Thread.sleep(2000);

	    billsave.ClickOnSave();
	    Thread.sleep(2000);
	}
	 // ✅ Check the success message
	    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    
	  //span[normalize-space()='Invoice Saved Successfully']

	   /* WebElement successPopup = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cdk-overlay-0\"]/snack-bar-container/simple-snack-bar/span"))); // update locator if needed
	    
	    String actualMessage = successPopup.getText();
	    String expectedMessage = "Invoice Saved Successfully!";

	    if (actualMessage.equals(expectedMessage)) {
	        System.out.println("✅ Success message is correct");
	    } else {
	        throw new AssertionError("❌ Expected: " + expectedMessage + ", but got: " + actualMessage);
	    }*/
	}

