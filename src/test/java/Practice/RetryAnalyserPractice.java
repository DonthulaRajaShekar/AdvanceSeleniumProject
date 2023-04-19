package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	
	@Test(retryAnalyzer = vitiger.GenericUtilites.RetryAnalyserImplementation.class)
	public void practice()
	{
		Assert.fail();
		System.out.println("Hai");
		System.out.println("hai Murali");
	}

}
