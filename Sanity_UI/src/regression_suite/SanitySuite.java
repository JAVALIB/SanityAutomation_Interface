package regression_suite;

import testdata.TestData;


public class SanitySuite
{
	public static String autURL = "";

	public static void main(String [] args)
	{
		long startTime;
		long endTime;
		
		TestData.initializeConfigFile();
		TestData.loadProperties_Sanity();
		
		startTime = System.currentTimeMillis();

		autURL = TestData.URL_14AT;
		
		TestData.getSanityReportLocation();
		
		teststeps.Lib_LoginLogout.Lib_Login(autURL);
		
//		San_TestCase.executePCLProvisioning();
//		San_TestCase.executeASN();
//		San_TestCase.executeCUG();
//		San_TestCase.executeFaultManagement();
//		San_TestCase.executeCeaseService();
		
//		San_TestCase.executeMaintainDepositReason();
//		San_TestCase.executeSinglePayment();
//		San_TestCase.executeQueryManagement();
//		San_TestCase.executeGenerateVerifyReport();
		
		teststeps.Lib_LoginLogout.Lib_LogoutExit();
		
		endTime = System.currentTimeMillis();
		System.out.println("Time took for total Execution is : " + (endTime - startTime)/1000 + " seconds." );
	}
}
