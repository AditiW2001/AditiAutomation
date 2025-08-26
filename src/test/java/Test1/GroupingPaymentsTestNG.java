package Test1;

import org.testng.annotations.Test;

public class GroupingPaymentsTestNG {
	
	@Test(priority =1, groups = {"sanity","regression","functional"})
	void paymentInRupees()
	{
		System.out.println("paymentInRupees");
	}

	@Test(priority =2,groups = {"sanity","regression","functional"})
	void paymentInDollars()
	{
		System.out.println("paymentInDollars");
	}

}
