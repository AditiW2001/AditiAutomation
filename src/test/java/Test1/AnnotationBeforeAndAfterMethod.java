package Test1;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationBeforeAndAfterMethod {

	@BeforeMethod
	void login()
	{
		System.out.println("Login....");
	}
	
	@Test(priority =1)
	void search() 
	{
		System.out.println("This is search....");
	}
	
	@Test(priority=2)
	void advancesearch()
	{
		System.out.println("This is advanced search....");
	}
	
	@AfterMethod
	void logout() 
	{
		System.out.println("Logout");
	}
}
