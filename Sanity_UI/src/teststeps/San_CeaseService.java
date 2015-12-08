package teststeps;

import java.awt.event.KeyEvent;

import regression_suite.Operations;
import regression_suite.TestStepActions;
import testcases.Check;
import testdata.TestData;

public class San_CeaseService 
{
	TestStepActions tsa = new TestStepActions();

	static String AccountNumber = TestData.AccountNumber;
	static String ServiceNumber = TestData.ServiceNumber;
	static String ServiceOrderNumber;
	
	static String xpath = "";
	static boolean passed;
	int i;
	
	public boolean testStep_1()
	{
		xpath = "//*[text()[contains(.,'Customer Care')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_2()
	{
		
		xpath = "//*[text()[contains(.,'Service Provisioning')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//input[contains(@name,'searchAcctNo')]";
		passed = tsa.sendDatatoField(xpath, TestData.AccountNumber);
		
		xpath = "//input[contains (@onclick,'enerate')]";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_3()
	{
		xpath = "//a[contains(@href,'customerServicesTabsWrapper')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_4()
	{
		passed = true;
		
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
		
		xpath = "(//span[text()[contains(.,'Cease')]])[1]";
		tsa.mouseMove(0,1100);
		tsa.keyPress(KeyEvent.VK_PAGE_UP);
		passed = tsa.clickOn(xpath);
		Operations.waitFor(1000);
		
		xpath = "//*[text()[contains(.,'Cease Service')]]";
		passed = tsa.waitUntilshort(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_5()
	{
		xpath = "//*[text()[contains(.,'Department')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//select[contains(@id,'departmentCode')]";
		passed = tsa.selectBy(xpath, TestData.Department);
		
		Operations.waitFor(1000);
		
		xpath = "//select[contains(@id,'siteCode')]";
		passed = tsa.selectBy(xpath, TestData.Site);
		
		xpath = "//input[contains(@value,'Proceed')]";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_6()
	{
		xpath = "//input[contains(@id,'ceaseAllblnChkBx')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		xpath = "(//*[text()[contains(.,'will be cease')]])[2]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "(//select[contains(@id,'ceaseServiceForm')])[1]";
		passed = tsa.selectBy(xpath, 1);
		//appForm2.selectByValue("1");
		
		xpath = "//input[@value = 'Accept']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_7()
	{
		xpath = "//*[text()[contains(.,'Service Order Lines')]]";
		passed = tsa.waitUntil(xpath);
		
		Check.closeError();

		Operations.waitFor(200);

		Check.closeError();
		
		xpath = "//td[contains(.,'Account Number')]/./following::span[@class='iceOutTxt'][1]";
		AccountNumber = tsa.getDatafromPage(xpath);
		
		xpath = "//td[contains(.,'Account Number')]/./following::span[@class='iceOutTxt'][3]";
		ServiceNumber = tsa.getDatafromPage(xpath);
		
		xpath = "//td[contains(.,'Account Number')]/./following::span[@class='iceOutTxt'][4]";
		ServiceOrderNumber = tsa.getDatafromPage(xpath);
		
		Operations.writetoUIconsole("");
		Operations.writetoUIconsole("AccountNumber : " + AccountNumber);
		Operations.writetoUIconsole("ServiceNumber : " + ServiceNumber);
		Operations.writetoUIconsole("ServiceOrder  : " + ServiceOrderNumber);
		
		TestData.ceaseSONumber = ServiceOrderNumber;
		
		Operations.waitFor(500);
		
		xpath = "//input[@value = 'Submit Order']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_8()
	{
		xpath ="//*[text()[contains(.,'Account Signoff')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//input[@value = 'OK']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_9()
	{
		xpath = "//input[@value = 'Accept']";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_10()
	{
		xpath = "//input[@id = 'signoffServiceOrderForm:Ok']";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		Operations.waitFor(200);

		return passed;
	}
	
	public boolean testStep_11()
	{
		xpath = "//*[text()[contains(.,'Service Order List')]]";
		passed = tsa.waitUntil(xpath);
		Operations.writetoUIconsole("Passed");
		
		return passed;
	}
	
}
