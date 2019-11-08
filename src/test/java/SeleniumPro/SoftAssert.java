package SeleniumPro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SoftAssert {
	
	
	@Test
	public void testsoftAssert()
	{
		
		SoftAssert softAssert=new SoftAssert();
		
		//Assert.assertTrue(true);
		//Assert.assertTrue(false);
		//Assert.assertEquals(5, "5");
		//Assert.assertEquals(5, 5);
		
		//Assert.assertAll();
		softAssert.assertTrue(true);
		softAssert.assertTrue(false);
		softAssert.assertEquals(5, "5");
		softAssert.assertEquals(5, 5);
		
		softAssert.assertAll();
		
		
		
	}

	private void assertEquals(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private void assertAll() {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(int i, String string) {
		// TODO Auto-generated method stub
		
	}

	private void assertTrue(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
