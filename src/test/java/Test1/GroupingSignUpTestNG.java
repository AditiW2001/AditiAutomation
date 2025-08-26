package Test1;

import org.testng.annotations.Test;

public class GroupingSignUpTestNG {

	@Test(priority =1, groups = {"regression"})
	void SignUpByEmail()
	{
		System.out.println("This is signup by email");
	}

	@Test(priority =2, groups = {"regression"})
	void SignUpByFacebook()
	{
		System.out.println("This is signup by Facebook");
	}

	@Test(priority =3, groups = {"regression"})
	void SignUpByTwitter()
	{
		System.out.println("This is signup by Twitter");
	}
}
