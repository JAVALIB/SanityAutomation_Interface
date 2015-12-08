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
		
		if (MainWindow.chckbxPCLProv.isSelected())
			San_TestCase.executePCLProvisioning();
		if (MainWindow.chckbxASN.isSelected())
			San_TestCase.executeASN();
		if (MainWindow.chckbxCUG.isSelected())
			San_TestCase.executeCUG();
		if (MainWindow.chckbxMaintainFault.isSelected())
			San_TestCase.executeFaultManagement();
		if (MainWindow.chckbxCease.isSelected())
			San_TestCase.executeCeaseService();
		if (MainWindow.chckbxQuery.isSelected())
			San_TestCase.executeMaintainDepositReason();
		if (MainWindow.chckbxSinglePay.isSelected())
			San_TestCase.executeSinglePayment();
		if (MainWindow.chckbxDepositReason.isSelected())
			San_TestCase.executeQueryManagement();
		if (MainWindow.chckbxReport.isSelected())
			San_TestCase.executeGenerateVerifyReport();
		
		teststeps.Lib_LoginLogout.Lib_LogoutExit();
		
		endTime = System.currentTimeMillis();
		System.out.println("Time took for total Execution is : " + (endTime - startTime)/1000 + " seconds." );
	}
}
