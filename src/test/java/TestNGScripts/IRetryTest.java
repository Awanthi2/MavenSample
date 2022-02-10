package TestNGScripts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryTest implements IRetryAnalyzer {
	int resultcount=0;
	public static final int maxRetyCount=3;

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(!result.isSuccess())
		{
			if(resultcount<maxRetyCount)
			{
				resultcount++;
				return false;
			}
			
		}
		return false;
	}

}
