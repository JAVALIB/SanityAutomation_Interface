package teststeps;

import org.openqa.selenium.StaleElementReferenceException;

import regression_suite.Operations;
import regression_suite.TestStepActions;
import testcases.Check;
import testdata.TestData;

public class San_CUG 
{
	static String AccountNumber = TestData.AccountNumber;
	static String ServiceNumber = TestData.ServiceNumber;
	static String CUGid			= TestData.CUGid;
	
	TestStepActions tsa = new TestStepActions();
	
	String xpath	= "";
	String serverDate;
	boolean passed	= true;
	
	public boolean testStep_1()
	{
		xpath = "//*[text()[contains(.,'Customer Care')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	public boolean testStep_2()
	{
		xpath = "//*[text()[contains(.,'Information')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	public boolean testStep_3()
	{
		xpath = "//a[contains(@href,'cugTab')]";
		passed = tsa.waitUntil(xpath);
		
		for (int i = 0; i < 3; i++) 
		{
			try 
			{
				passed = tsa.clickOn(xpath);
			}
			catch (StaleElementReferenceException e) 
			{
				Operations.waitFor(100);
				Operations.writetoUIconsole("\tStale element occured. Retrying..");
			}
		}
		return passed;
	}
	public boolean testStep_4()
	{
		xpath = "//*[text()[contains(.,'New')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	public boolean testStep_5()
	{
		xpath = "//input[contains(@id,'CUGID')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.sendDatatoField(xpath, CUGid);
		
		xpath = "//input[contains(@id,'Description')]";
		passed = tsa.sendDatatoField(xpath, "Automation CUG");
		
		xpath = "//input[contains(@id,'CUGType:_2')]";
		passed = tsa.clickOn(xpath);
		
		xpath = "//input[contains(@id,'maxNoOfServices')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.sendDatatoField(xpath, "10");
		
		xpath = "//select[contains(@id,'chargeGroupType')]";
		tsa.selectBy(xpath, 2);
		
		xpath = "//select[contains(@id,'calltypeSelect') and contains(@style,'background-color')]";
		if (tsa.elementExist(xpath))
		{
			tsa.selectBy(xpath, "CE");
		}
		
		Operations.waitFor(1000);
		
		xpath = "//input[@value = 'Accept']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	public boolean testStep_6()
	{
		xpath = "//*[text()[contains(.,'uccessfully')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//a[contains(@href,'cugTab')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	public boolean testStep_7()
	{
		xpath = "//input[contains(@id,'cugSearch:exdir:_2')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		xpath = "//input[@class = 'iceInpTxt']";
		passed = tsa.waitUntil(xpath);
		passed = tsa.sendDatatoField(xpath, CUGid);
		
		xpath = "//input[@value= 'Search']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	public boolean testStep_8()
	{
		xpath = "//tr[contains(@id,'cugTabForm:cugTabs:0')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		xpath = "//a[@id='cugTabForm:cugTabs:0.5']";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	public boolean testStep_9()
	{
		xpath = "//*[text()[contains(.,'" + CUGid + "')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//*[text()[contains(.,'New')]]";
		Operations.waitFor(1000);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	public boolean testStep_10()
	{
	
		xpath = "//input[contains(@id,'cugServices:ServiceNo')]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//input[contains(@id,'cugServices:ServiceNo')]";
		passed = tsa.sendDatatoField(xpath, ServiceNumber);
		
		xpath = "//input[@value='Validate CUG No.']";
		passed = tsa.clickOn(xpath);
		
		xpath = "//*[text()[contains(.,'riority:')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//input[@value='OK']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	public boolean testStep_11()
	{
		xpath = "//tr[contains(@id,'cug_Services_data_table_')]";
		passed = tsa.waitUntil(xpath);
		
		return passed;
	}
	public boolean testStep_12()
	{
		passed = tsa.waitUntil(xpath);
		xpath = "//*[text()[contains(.,'Customer Care')]]";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	public boolean testStep_13()
	{
		xpath = "//input[contains(@name,'searchAcctNo')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.sendDatatoField(xpath, AccountNumber);
		
		xpath = "//input[contains (@onclick,'enerate')]";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_14()
	{
		xpath = "//*[text()[starts-with(.,'" + AccountNumber + "')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//a[contains(@href,'customerServicesTabsWrapper')]";
		passed = tsa.clickOn(xpath);
				
		return passed;
	}
	public boolean testStep_15()
	{
		xpath = "//a[contains(@id,'customerServicesForm:serviceEnquiryTabs:0.3')]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//input[contains(@id,'summaryTab:servNumToSearch')]";
		Check.closeError();
		Operations.waitFor(1000);
		
		if(tsa.elementExist(xpath))
		{
			passed = tsa.sendDatatoField(xpath, ServiceNumber);
		
			xpath = "//input[contains(@class,'iceSelBoolChkbx')]";
			passed = tsa.clickOn(xpath);
		
			xpath = "//input[contains(@value,'Search') and @type='submit']";
			passed = tsa.clickOn(xpath);
		}

		xpath = "//tr[contains(@class,'ui-selected ui-state-active')]";
		passed = tsa.waitUntil(xpath);
		
		return passed;
	}
	
	public boolean testStep_16()
	{
		xpath = "//a[contains(@id,'customerServicesForm:serviceEnquiryTabs:0.3')]";
		passed = tsa.clickOn(xpath);
		
		try
		{
			xpath = "//*[text()[contains(.,'" + CUGid + "')]]";
			passed = tsa.waitUntil(xpath);
			passed = tsa.clickOn(xpath);
			Operations.writetoUIconsole("CUG Passed");		
		}
		
		catch(Exception e)
		{
			Operations.writetoUIconsole("Number not added to CUG " + CUGid + " properly");
		}
		
		return passed;
	}

}

