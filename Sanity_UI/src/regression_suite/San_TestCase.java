package regression_suite;

import application_ui.MainWindow;
import testcases.Exec_San_ASN;
import testcases.Exec_San_CUG;
import testcases.Exec_San_CeaseService;
import testcases.Exec_San_FaultManagement;
import testcases.Exec_San_GenerateVerifyReport;
import testcases.Exec_San_MaintainDepositReason;
import testcases.Exec_San_PCLProvisioning;
import testcases.Exec_San_QueryManagement;
import testcases.Exec_San_SinglePayment;
import testdata.GenerateData;

public class San_TestCase 
{

	public static void executePCLProvisioning()
	{
		TestConfiguration.resetConfiguration();
		GenerateData.customerID();
		GenerateData.customerFirstname();
		GenerateData.customerSurname();
		TestConfiguration.scenarioName = "San_PCLProvisioning";
		TestConfiguration.testStatus = Exec_San_PCLProvisioning.execute();
		
		MainWindow.San_PCLProvisioning_status.setText(TestReport.getPassedFailed(TestConfiguration.testStatus));
		Operations.setTestStatusColor(MainWindow.San_PCLProvisioning_status);
		
		TestReport.createScreenshotDocument();
	}
	
	public static void executeASN() 
	{
		TestConfiguration.resetConfiguration();
		TestConfiguration.scenarioName = "San_ASN";
		TestConfiguration.testStatus = Exec_San_ASN.execute();
		
		MainWindow.San_ASN_status.setText(TestReport.getPassedFailed(TestConfiguration.testStatus));
		Operations.setTestStatusColor(MainWindow.San_ASN_status);

		TestReport.createScreenshotDocument();		
	}

	public static void executeCUG() 
	{
		TestConfiguration.resetConfiguration();
		TestConfiguration.scenarioName = "San_CUG";
		GenerateData.CUGid();
		TestConfiguration.testStatus = Exec_San_CUG.execute();
		
		MainWindow.San_CUG_status.setText(TestReport.getPassedFailed(TestConfiguration.testStatus));
		Operations.setTestStatusColor(MainWindow.San_CUG_status);

		TestReport.createScreenshotDocument();		
	}

	public static void executeFaultManagement() 
	{
		TestConfiguration.resetConfiguration();
		TestConfiguration.scenarioName = "San_FaultManagement";
		TestConfiguration.testStatus = Exec_San_FaultManagement.execute();
		
		MainWindow.San_FaultManagement_status.setText(TestReport.getPassedFailed(TestConfiguration.testStatus));
		Operations.setTestStatusColor(MainWindow.San_FaultManagement_status);

		TestReport.createScreenshotDocument();		
	}

	public static void executeCeaseService() 
	{
		TestConfiguration.resetConfiguration();
		TestConfiguration.scenarioName = "San_CeaseService";
		TestConfiguration.testStatus = Exec_San_CeaseService.execute();
		
		MainWindow.San_CeaseService_status.setText(TestReport.getPassedFailed(TestConfiguration.testStatus));
		Operations.setTestStatusColor(MainWindow.San_CeaseService_status);

		TestReport.createScreenshotDocument();		
	}
	
	public static void executeMaintainDepositReason()
	{
		TestConfiguration.resetConfiguration();
		GenerateData.depReasonCode();
		TestConfiguration.scenarioName = "San_MaintainDepositReason";
		TestConfiguration.testStatus = Exec_San_MaintainDepositReason.execute();
		
		MainWindow.San_MaintainDepositReason_status.setText(TestReport.getPassedFailed(TestConfiguration.testStatus));
		Operations.setTestStatusColor(MainWindow.San_MaintainDepositReason_status);

		TestReport.createScreenshotDocument();
	}
	
	public static void executeSinglePayment()
	{
		TestConfiguration.resetConfiguration();
		TestConfiguration.scenarioName = "San_SinglePayment";
		TestConfiguration.testStatus = Exec_San_SinglePayment.execute();
		
		MainWindow.San_SinglePayment_status.setText(TestReport.getPassedFailed(TestConfiguration.testStatus));
		Operations.setTestStatusColor(MainWindow.San_SinglePayment_status);

		TestReport.createScreenshotDocument();
	}
	
	public static void executeQueryManagement() 
	{
		TestConfiguration.resetConfiguration();
		TestConfiguration.scenarioName = "San_QueryManagement";
		TestConfiguration.testStatus = Exec_San_QueryManagement.execute();
		
		MainWindow.San_QueryManagement_status.setText(TestReport.getPassedFailed(TestConfiguration.testStatus));
		Operations.setTestStatusColor(MainWindow.San_QueryManagement_status);

		TestReport.createScreenshotDocument();
	}
	
	public static void executeGenerateVerifyReport()
	{
		TestConfiguration.resetConfiguration();
		TestConfiguration.scenarioName = "San_GenerateVerifyReport";
		TestConfiguration.testStatus = Exec_San_GenerateVerifyReport.execute();
		
		MainWindow.San_GenerateVerifyReport_status.setText(TestReport.getPassedFailed(TestConfiguration.testStatus));
		Operations.setTestStatusColor(MainWindow.San_GenerateVerifyReport_status);

		TestReport.createScreenshotDocument();
	}


}
