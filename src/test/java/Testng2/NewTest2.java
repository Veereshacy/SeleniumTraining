package Testng2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class NewTest2 {
  @Test(groups = {"smoke","dry"})
  public void Test1() {
	  System.out.println("Test1");
  }
  @Test(groups = {"dry"})
  public void Test2() {
	  System.out.println("Test2");
  }
  @Test(groups = {"dry"})
  public void Test3() {
	  System.out.println("Test3");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("aftertmeth");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("bfclass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("atfer");
  }

}
