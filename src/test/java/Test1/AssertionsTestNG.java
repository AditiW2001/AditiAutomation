package Test1;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AssertionsTestNG {

	@Test
	void testTitle()
	{
	String act_title = "Opencart";
	String exp_title = "Opencart";
	
    Assert.assertEquals(exp_title, act_title);
    
    if(exp_title.equals(act_title))
    {
    	System.out.println("Test Passed"); 
    	Assert.assertTrue(true);
    }
    else
    {
    	System.out.println("Test Failed");
    	Assert.assertTrue(false);
    }
	}
}
