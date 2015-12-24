package teststeps;

import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;

import regression_suite.Operations;
import regression_suite.SanitySuite;
import regression_suite.TestStepActions;
import testcases.Check;
import testdata.TestData;
import application_ui.MainWindow;

public class San_ASN 
{
	static String AccountNumber = TestData.AccountNumber;
	static String ServiceNumber = TestData.ServiceNumber;
	static String ServiceOrderNumber;
	
	TestStepActions tsa = new TestStepActions();
	
	String xpath	= "";
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
		xpath = "//*[text()[contains(.,'Service Provisioning')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//input[contains(@name,'searchAcctNo')]";
		passed = tsa.clearInputField(xpath);
		passed = tsa.sendDatatoField(xpath, AccountNumber);
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
		xpath = "(//*[text()[contains(.,'Install Date')]])[1]";
		passed = tsa.waitUntil(xpath);
		
		Check.closeError();
		Operations.waitFor(1000);
		
		xpath = "//input[contains(@id,'servNumToSearch')]";
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
		
		xpath = "(//span[text()[contains(.,'Change')]])[3]";
		tsa.mouseMove(0,1100);
		tsa.keyPress(KeyEvent.VK_PAGE_UP);
		passed = tsa.clickOn(xpath);
		Operations.waitFor(1000);
		
		xpath = "//*[text()[contains(.,'ASN')]]";
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
		
		Operations.waitFor(200);
		
		xpath = "//select[contains(@id,'serviceNumberAllocate')]";
		passed = tsa.selectBy(xpath, "Auto");
		
		xpath = "//input[@type='checkbox' and @checked='checked']";
		boolean checked = tsa.elementExist(xpath);
		
		if (checked)
		{
			passed = tsa.clickOn(xpath);
		}
		
		xpath = "//input[@value = 'Accept']";
		passed = tsa.clickOn(xpath);
		
		Check.closeError();

		Check.closeError();

		Operations.waitFor(1000);

		Check.closeError();

		Operations.waitFor(200);

		Check.closeError();
		
		tsa.closeOKpopup();
		
		return passed;
	}
	
	public boolean testStep_6()
	{
		xpath = "//*[text()[contains(.,'Service Order Lines')]]";
		passed = tsa.waitUntil(xpath);
		
		Check.closeError();
		Operations.waitFor(1000);
		Check.closeError();
		
		xpath = "//td[contains(.,'Account Number')]/./following::span[@class='iceOutTxt'][4]";
		ServiceOrderNumber = tsa.getDatafromPage(xpath);
		
		TestData.asnSONumber = ServiceOrderNumber;
		
		Operations.waitFor(500);
		
		xpath = "//input[@value = 'Submit Order']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_7()
	{
		xpath ="//*[text()[contains(.,'Account Signoff')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//*[text()[contains(.,'Service Number:')]]/./following::span[@style='font-weight:bold;']";
		TestData.ServiceNumber = tsa.getDatafromPage(xpath);
		ServiceNumber = TestData.ServiceNumber;
		
		xpath = "//input[@value = 'OK']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_8()
	{
		xpath = "//input[@value = 'Accept']";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_9()
	{
		xpath = "//input[@id = 'signoffServiceOrderForm:Ok']";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		Operations.waitFor(1000);
		
		return passed;
	}
	
	public boolean testStep_10()
	{
		xpath = "//*[text()[contains(.,'Service Order List')]]";
		passed = tsa.waitUntilshort(xpath);
		
		MainWindow.writetoUIconsole("");
		MainWindow.writetoUIconsole("AccountNumber : " + AccountNumber);
		MainWindow.writetoUIconsole("ServiceNumber : " + ServiceNumber);
		MainWindow.writetoUIconsole("ServiceOrder  : " + ServiceOrderNumber);
		
		try
		{
			if(TestData.initializeConfigFile())
			{
				if (SanitySuite.autURL == TestData.URL_14AT)
				{
					TestData.props.setProperty("ServiceNumber", TestData.ServiceNumber);
					
					FileWriter writer = new FileWriter("config.properties");
					TestData.props.store(writer, "automation settings");
				    writer.close();
				}
				else if (SanitySuite.autURL == TestData.URL_13BT)
				{
					TestData.props.setProperty("ServiceNumber", TestData.ServiceNumber);
					
					FileWriter writer = new FileWriter("config.properties");
					TestData.props.store(writer, "automation settings");
				    writer.close();
				}
			}
		}
		catch(IOException io)
		{
			MainWindow.writetoUIconsole("IOException occured. Please update datafile(config file) manually");
		}
		
		return passed;
	}
}
