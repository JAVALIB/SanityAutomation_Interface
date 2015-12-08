package regression_suite;

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
		TestReport.createScreenshotDocument();
	}
	
	public static void executeASN() 
	{
		TestConfiguration.resetConfiguration();
		TestConfiguration.scenarioName = "San_ASN";
		TestConfiguration.testStatus = Exec_San_ASN.execute();
		TestReport.createScreenshotDocument();		
	}

	public static void executeCUG() 
	{
		TestConfiguration.resetConfiguration();
		TestConfiguration.scenarioName = "San_CUG";
		GenerateData.CUGid();
		TestConfiguration.testStatus = Exec_San_CUG.execute();
		TestReport.createScreenshotDocument();		
	}

	public static void executeFaultManagement() 
	{
		TestConfiguration.resetConfiguration();
		TestConfiguration.scenarioName = "San_FaultManagement";
		TestConfiguration.testStatus = Exec_San_FaultManagement.execute();
		TestReport.createScreenshotDocument();		
	}

	public static void executeCeaseService() 
	{
		TestConfiguration.resetConfiguration();
		TestConfiguration.scenarioName = "San_CeaseService";
		TestConfiguration.testStatus = Exec_San_CeaseService.execute();
		TestReport.createScreenshotDocument();		
	}
	
	public static void executeMaintainDepositReason()
	{
		TestConfiguration.resetConfiguration();
		GenerateData.depReasonCode();
		TestConfiguration.scenarioName = "San_MaintainDepositReason";
		TestConfiguration.testStatus = Exec_San_MaintainDepositReason.execute();
		TestReport.createScreenshotDocument();
	}
	
	public static void executeSinglePayment()
	{
		TestConfiguration.resetConfiguration();
		TestConfiguration.scenarioName = "San_SinglePayment";
		TestConfiguration.testStatus = Exec_San_SinglePayment.execute();
		TestReport.createScreenshotDocument();
	}
	
	public static void executeQueryManagement() 
	{
		TestConfiguration.resetConfiguration();
		TestConfiguration.scenarioName = "San_QueryManagement";
		TestConfiguration.testStatus = Exec_San_QueryManagement.execute();
		TestReport.createScreenshotDocument();
	}
	
	public static void executeGenerateVerifyReport()
	{
		TestConfiguration.resetConfiguration();
		TestConfiguration.scenarioName = "San_GenerateVerifyReport";
		TestConfiguration.testStatus = Exec_San_GenerateVerifyReport.execute();
		TestReport.createScreenshotDocument();
	}


}
