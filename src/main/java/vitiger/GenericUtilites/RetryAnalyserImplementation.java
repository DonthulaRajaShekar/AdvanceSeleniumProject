package vitiger.GenericUtilites;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * this class provide implementation for iRereyAnalyser interface of TestNG
 * @author HP
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{
	int count=0;
	int retrycount=3;
	/**
	 * this method will retry for 3 times
	 */
	public boolean retry(ITestResult result) {
		while(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
	}

}
