package Test1;
import org.testng.annotations.Test;

/*
 * 1.Open app
 * 2.Login
 * 3.Logout
 */

public class TestNGAnnotations {
	
	@Test(priority = 3)
	void Logout()
	{
		System.out.println("logout from application....");

	}
	
	@Test(priority = 1)
	void Openapp()
	{
		System.out.println("opening application....");
	}
	
	@Test(priority = 2)
	void Login()
	{
		System.out.println("login to application....");

	}
	
	

}
