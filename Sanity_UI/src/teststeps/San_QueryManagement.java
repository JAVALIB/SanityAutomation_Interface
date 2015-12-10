package teststeps;

import java.awt.event.KeyEvent;

import org.openqa.selenium.support.ui.WebDriverWait;

import regression_suite.Operations;
import regression_suite.TestStepActions;
import testdata.TestData;
import application_ui.MainWindow;

public class San_QueryManagement 
{
	static WebDriverWait longWait = Operations.longWait;

	TestStepActions tsa = new TestStepActions();
	
	static String accountNumber = TestData.AccountNumber;
	static String RaisedQueryNumber;
	
	String xpath	= "";
	boolean passed	= true;
	
	public boolean testStep_1()
	{
		xpath = "//*[text()[contains(.,'Customer Care')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		xpath = "//*[text()[contains(.,'Service Provisioning')]]";
		passed = tsa.waitUntil(xpath);
		
		//TODO Change Hard Coded account number. Retrieve it from a data source
		xpath = "//input[contains(@name,'searchAcctNo')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.sendDatatoField(xpath, accountNumber);
		
		xpath = "//input[contains (@onclick,'enerate')]";
		passed = tsa.clickOn(xpath);
		
		//change status to true id passed (no exception)
		return passed;
	}
	
	public boolean testStep_2()
	{
		xpath = "//*[text()[contains(.,'More')]]";
		passed = tsa.waitUntil(xpath);

		xpath = "//a[@class='iceLink' and contains(@href, '/querymanagement/customerCareRaiseNewQuery.xhtml')]";
		passed = tsa.clickOn(xpath);

		return passed;
	}
	
	public boolean testStep_3()
	{
		xpath = "//*[text()[contains(.,'nquirer')]]";
		passed = tsa.waitUntil(xpath);

		//TODO Send Enquirer name only when Enquirer name is not available
		//driver.findElement(By.xpath("//input[contains(@maxlength,'40') and (@style,'')])]")).sendKeys("Test Enquirer");
		xpath = "//*[contains(@class,'iceSelOneMnu MandatoryListBox')]";
		passed = tsa.selectBy(xpath, "CD");
		
		Operations.waitFor(2000);
		
		xpath = "//select[contains(@class,'iceSelOneMnu MandatoryListBox')]/./following::select[contains(@class,'iceSelOneMnu MandatoryListBox')]";
		passed = tsa.selectBy(xpath, "WC");
		
		xpath = "//*[contains(@class,'iceInpTxtArea')]";
		passed = tsa.sendDatatoField(xpath, "Test Raise Query - Note 1");
		
		xpath = "//*[contains(@value,'Accept')]";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_4()
	{
		xpath = "//*[text()[contains(.,'Query Number:')]]";
		passed = tsa.waitUntil(xpath);

		xpath = "//td[contains(.,'Query Number')]/./following::span[@class='iceOutTxt'][1]";
		RaisedQueryNumber = tsa.getDatafromPage(xpath);
		
		if (RaisedQueryNumber != "")
		{
			MainWindow.writetoUIconsole("Raised Query Number : " + RaisedQueryNumber);
			passed = true;
		}
		else
		{
			MainWindow.writetoUIconsole("Query Number Not available..");
			passed = false;
		}
		
		xpath = "(//a[contains(@class,'iceCmdLnk') and contains(@id,'customerCareQueriesForm')])[3]";
		passed = tsa.waitUntil(xpath);
		
		Operations.keyPress(KeyEvent.VK_PAGE_UP);

		passed = tsa.clickOn(xpath);

		//Add exception handling
		//change status to true id passed (no exception)
		return passed;
	}
	
	public boolean testStep_5()
	{
		xpath = "//*[contains(@class,'iceInpTxtArea')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.sendDatatoField(xpath, "Test Raise Query - Note 2");
		
		Operations.waitFor(500);
		xpath = "//input[contains(@value,'ack')]";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_6()
	{
		passed = tsa.waitUntil(xpath);
		
		Operations.keyPress(KeyEvent.VK_PAGE_UP);
		Operations.waitFor(1000);
		
		xpath = "(//a[contains(@class,'iceCmdLnk') and contains(@id,'customerCareQueriesForm')])[4]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);

		return passed;
	}
	
	public boolean testStep_7()
	{
		xpath = "//select[@id='queryManagementProgressForm:modifyqrystatus']";
		passed = tsa.waitUntil(xpath);
		passed = tsa.selectBy(xpath, "RE");
		
		Operations.waitFor(2000);

		xpath = "//select[@id='queryManagementProgressForm:dept']";
		passed = tsa.selectBy(xpath, 3);
		
		Operations.waitFor(2000);
		
		xpath = "//input[@value='Accept']";
		passed = tsa.clickOn(xpath);

		Operations.waitFor(2000);

		return passed;
	}
	
	public boolean testStep_8()
	{
		xpath = "//*[text()[contains(.,'Sign Off')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_9()	
	{
		xpath = "//select[contains(@id,'signoffAdjustmentQueryForm')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.selectBy(xpath,3);

		Operations.waitFor(1000);
		
		xpath = "//input[@value='Accept']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_10()
	{
		xpath = "//*[text()[contains(.,'Query Details')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//*[text()[contains(.,'Signed Off as Complete')]]";
		passed = tsa.waitUntil(xpath);
		
		return passed;
	}

}
