package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefs {
	
	public WebDriver driver;
	public LoginPage loginPg;


	@Given("user launch Chrome Browser")
	public void user_launch_chrome_browser() {
	    WebDriverManager.chromedriver().setup();
	    driver  = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    loginPg = new LoginPage(driver);
	}

	@When("user open URL {string}")
	public void user_open_url(String url) {
	    driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) {
		loginPg.enterEmail(emailadd);
		loginPg.enterPassword(password);
	}

	@When("Clicks on Login")
	public void clicks_on_login() throws InterruptedException {
	loginPg.clickOnLoginBtn();
	Thread.sleep(3000);
	}

	/*When("User Selects Sylphy Group")
	public void user_Selects_Sylphy_Group() throws InterruptedException {
	    loginPg.clickOnGroup();
	    Thread.sleep(3000);
	}*/
	
	@When("User Clicks on User Profile")
	public void user_Clicks_on_User_Profile() throws InterruptedException {
	    loginPg.clickOnUserProfile();
	    Thread.sleep(3000);
	}
	
	@When("User clicks on Logout link")
	public void user_clicks_on_logout_link() {
	    loginPg.clickOnLogoutBtn();
	}

	@Then("close the browser.")
	public void close_the_browser() {
		driver.close();
		driver.quit();
	}
}
