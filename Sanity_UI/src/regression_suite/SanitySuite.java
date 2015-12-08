package regression_suite;

import testdata.TestData;
import application_ui.MainWindow;


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
		
		if (MainWindow.San_PCLProvisioning.isSelected())
			San_TestCase.executePCLProvisioning();
		if (MainWindow.San_ASN.isSelected())
			San_TestCase.executeASN();
		if (MainWindow.San_CUG.isSelected())
			San_TestCase.executeCUG();
		if (MainWindow.San_FaultManagement.isSelected())
			San_TestCase.executeFaultManagement();
		if (MainWindow.San_CeaseService.isSelected())
			San_TestCase.executeCeaseService();
		if (MainWindow.San_QueryManagement.isSelected())
			San_TestCase.executeMaintainDepositReason();
		if (MainWindow.San_SinglePayment.isSelected())
			San_TestCase.executeSinglePayment();
		if (MainWindow.San_MaintainDepositReason.isSelected())
			San_TestCase.executeQueryManagement();
		if (MainWindow.San_GenerateVerifyReport.isSelected())
			San_TestCase.executeGenerateVerifyReport();
		
		teststeps.Lib_LoginLogout.Lib_LogoutExit();
		
		endTime = System.currentTimeMillis();
		Operations.writetoUIconsole("Time took for total Execution is : " + (endTime - startTime)/1000 + " seconds." );
	}
}
