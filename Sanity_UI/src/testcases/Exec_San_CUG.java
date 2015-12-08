package testcases;

import regression_suite.Operations;
import teststeps.San_CUG;

public class Exec_San_CUG 
{
static San_CUG  ts = new San_CUG ();
	
	static boolean passed = true;
	
	public static boolean execute()
	{
		for(int i=0;i<1;i++)
		{
			passed = ts.testStep_1();
			Operations.takeScreenshot();
			if(!passed)
				break;
			
			passed = ts.testStep_2();
			Operations.takeScreenshot();
			if(!passed)
				break;
			
			passed = ts.testStep_3();
			Operations.takeScreenshot();
			if(!passed)
				break;
			
			passed = ts.testStep_4();
			Operations.takeScreenshot();
			if(!passed)
				break;
			
			passed = ts.testStep_5();
			Operations.takeScreenshot();
			if(!passed)
				break;
			
			passed = ts.testStep_6();
			Operations.takeScreenshot();
			if(!passed)
				break;
			
			passed = ts.testStep_7();
			Operations.takeScreenshot();
			if(!passed)
				break;
			
			passed = ts.testStep_8();
			Operations.takeScreenshot();
			if(!passed)
				break;
			
			passed = ts.testStep_9();
			Operations.takeScreenshot();
			if(!passed)
				break;
			
			passed = ts.testStep_10();
			Operations.takeScreenshot();
			if(!passed)
				break;
			
			passed = ts.testStep_11();
			Operations.takeScreenshot();
			if(!passed)
				break;
			
			passed = ts.testStep_12();
			Operations.takeScreenshot();
			if(!passed)
				break;
			
			passed = ts.testStep_13();
			Operations.takeScreenshot();
			if(!passed)
				break;
			
			passed = ts.testStep_14();
			Operations.takeScreenshot();
			if(!passed)
				break;
			
			passed = ts.testStep_15();
			Operations.takeScreenshot();
			if(!passed)
				break;
			
			passed = ts.testStep_16();
			Operations.takeScreenshot();
			if(!passed)
				break;
		}
		
		return passed;
	}
}
