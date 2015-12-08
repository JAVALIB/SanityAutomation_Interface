package teststeps;

import org.openqa.selenium.TimeoutException;

import regression_suite.Operations;
import regression_suite.SanitySuite;
import regression_suite.TestStepActions;
import testcases.Check;
import testdata.TestData;

public class San_FaultManagement 
{
	static String ServiceNumber = "";
	static String FaultNumber = "";
	static String FaultNote = "Sanity Automation Fault Notes";
	static String clearCode;
	
	TestStepActions tsa = new TestStepActions();
	
	String xpath	= "";
	boolean passed	= true;
	
	public boolean testStep_1()
	{
		xpath = "//*[text()[contains(.,'Faults')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_2()
	{
		xpath = "//*[text()[contains(.,'Raise Fault')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_3()
	{
		xpath = "//input[contains(@id,'serviceNumber')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.sendDatatoField(xpath, TestData.ServiceNumber);
		Operations.waitFor(500);
		xpath = "//input[@value = 'Raise Fault']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_4()
	{
		xpath = "//select[contains(@id,'symptom')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.selectBy(xpath, 1);
		//appForm.selectByValue("31");
		
		Operations.waitFor(500);
		xpath = "//select[contains(@id,'diagnosis')]"; 
		passed = tsa.selectBy(xpath, 1);
		//appForm1.selectByValue("2");
		
		Operations.waitFor(750);
		xpath = "//select[contains(@id,'departments')]";
		passed = tsa.selectBy(xpath, 1);
		//appForm2.selectByValue("FLT-R");
		
		Operations.waitFor(750);
		xpath = "//input[@value='Accept']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_5()
	{
		xpath = "//*[text()[contains(.,'Fault Number')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//td[contains(.,'Fault Number')]/./following::span[@class='iceOutTxt'][1]";
		FaultNumber = tsa.getDatafromPage(xpath);
		System.out.println(FaultNumber);
		
		xpath = "//*[text()[contains(.,'Manage Fault')]]";
		passed = tsa.clickOn(xpath);
		Operations.waitFor(500);

		return passed;
	}
	
	public boolean testStep_6()
	{
		xpath = "//input[@maxlength = 7]";
		passed = tsa.waitUntil(xpath);
		
		passed = tsa.sendDatatoField(xpath, FaultNumber);
		
		xpath = "//input[@value='Search']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_7()
	{
		Check.closeError();
		
		xpath = "//*[text()[contains(.,'Maintain Fault Notes')]]";
		passed = tsa.waitUntil(xpath);
		
		Check.closeError();
		Operations.waitFor(1000);
		
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_8()
	{
		xpath = "//input[@value='Add Notes']";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_9()
	{
		xpath = "//textarea[@id='manageFault:manageNotes']";
		passed = tsa.waitUntil(xpath);
		passed = tsa.sendDatatoField(xpath, FaultNote);
		
		xpath = "//input[@value='Apply']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_10()
	{
		xpath = "//*[text()[contains(.,'" + FaultNote +"')]]";
		
		try
		{
			passed = tsa.waitUntil(xpath);
			return passed;
		}
		catch (TimeoutException e)
		{
			return false;
		}
	}
	
	public boolean testStep_11()
	{
		xpath = "//*[text()[contains(.,'Assign Fault')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);

		return passed;
	}
	
	public boolean testStep_12()
	{
		xpath = "//input[@id='manageFault:startingWithEmp']";
		passed = tsa.waitUntil(xpath);
		passed = tsa.sendDatatoField(xpath, "99999");
		
		xpath = "//input[@id='manageFault:filterEngineerId']";
		passed = tsa.clickOn(xpath);
		
		Operations.waitFor(1500);
		
		xpath ="//select[@id='manageFault:assignSelectEngineerID']";
		passed = tsa.selectBy(xpath, 1);
		
		xpath = "//input[@value='Assign']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_13()
	{
		xpath = "//*[text()[contains(.,'Assignment')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//*[text()[contains(.,'Sign Off')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		xpath = "//*[text()[contains(.,'Cleared By')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//select[contains(@id,'signoffCleardByID')]";
		passed = tsa.selectBy(xpath, 2);
		//appForm3.selectByValue("2222");
		Operations.waitFor(1500);
		
		xpath = "//select[contains(@id,'signoffselectClearCode1ID')]";
		if (SanitySuite.autURL == TestData.URL_13BT)
		{
			clearCode = "6";
		}
		else if (SanitySuite.autURL == TestData.URL_14AT)
		{
			clearCode = "60";
		}
		passed = tsa.selectBy(xpath, clearCode);
		Operations.waitFor(1500);
		
		xpath = "//select[contains(@id,'signoffselectClearCode2ID')]";
		passed = tsa.selectBy(xpath, 1);
		//appForm5.selectByValue("3");
		Operations.waitFor(1500);
		
		xpath = "//select[contains(@id,'signoffselectClearCode3ID')]";
		passed = tsa.selectBy(xpath, 1);
		//appForm6.selectByValue("1");
		Operations.waitFor(1500);
		
		xpath = "//select[contains(@id,'signoffclearActionID')]";
		passed = tsa.selectBy(xpath, 1);
		Operations.waitFor(1000);
		
		xpath = "//input[@value = 'Apply']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_14()
	{
		xpath = "//*[text()[contains(.,'Cleared')] and @id='manageFault:faultStatusId']";
		passed = tsa.waitUntil(xpath);
		String FaultStatus = tsa.getDatafromPage(xpath);
		
		if (FaultStatus == "Cleared")
		{
			System.out.println("Passed");
			passed = true;
		}
		else
		{
			System.out.println("Failed");
			passed = false;
		}
		return passed;
	}
}
