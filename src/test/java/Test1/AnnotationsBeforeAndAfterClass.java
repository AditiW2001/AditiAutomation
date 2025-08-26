package Test1;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AnnotationsBeforeAndAfterClass {

	@BeforeClass
	void login()
	{
		System.out.println("Login...");
	}

	@Test(priority=1)
	void search()
	{
       System.out.println("This is search");
	}
	
	@Test(priority=2)
	void advancesearch()
	{
		System.out.println("This is advanced search");
	}

	@AfterClass
	void logout()
	{
		System.out.println("Logout");
	}
}
