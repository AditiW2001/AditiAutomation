package Test1;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
public class HardVsSoftAssertions {

	/*@Test
	void HardAssertions()
	{
		System.out.println("Test 1");
		System.out.println("Test 2");

		Assert.assertEquals(1, 2);

		System.out.println("Test 3");
		System.out.println("Test 4");

	}*/

	@Test
	void SoftAssertions()
	{
		SoftAssert sa =  new SoftAssert();   //object of SoftAssert class

		System.out.println("Test 1");
		System.out.println("Test 2");

		sa.assertEquals(1, 2);

		System.out.println("Test 3");
		System.out.println("Test 4");

	}


}
