package Practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test
	public void createUser()
	{
		System.out.println("create");
	}
	@Test(invocationCount = 0)
	public void updateUser()
	{
		System.out.println("update");
	}
	@Test
	public void deleteUser()
	{
		System.out.println("delete");
	}
}
