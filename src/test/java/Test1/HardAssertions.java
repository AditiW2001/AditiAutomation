package Test1;
import org.testng.annotations.Test;
import org.testng.Assert;


public class HardAssertions {
	
	@Test
	void test()
	{
	
		//Assert.assertEquals("xyz", "xyz");  //compares strings
		//Assert.assertEquals(123, 345); //compares numbers
		//Assert.assertEquals("345", 345);  //string cannot be compared with numbers

        //Assert.assertNotEquals(123, 123);
        //Assert.assertNotEquals(123, 345);

        //Assert.assertTrue(true);
        //Assert.assertTrue(false);
		
        //Assert.assertTrue(1==2); //Fail
        //Assert.assertTrue(1==1); //pass

        //Assert.assertFalse(1==2);  //pass
        //Assert.assertFalse(1==1);  //fail
		
	 

        
	}

}
