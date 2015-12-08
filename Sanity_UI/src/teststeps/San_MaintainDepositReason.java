package teststeps;

import java.awt.event.KeyEvent;

import org.openqa.selenium.support.ui.WebDriverWait;

import regression_suite.Operations;
import regression_suite.TestStepActions;
import testdata.TestData;

public class San_MaintainDepositReason 
{
	static WebDriverWait longWait = Operations.longWait;

	TestStepActions tsa = new TestStepActions();
	
	static String depReasonCode = TestData.depReasonCode;
	
	String xpath	= "";
	boolean passed	= true;
	
	public boolean testStep_1()
	{
		xpath = "//*[text()[contains(.,'Credit Control')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_2()
	{
		xpath = "//*[text()[contains(.,'Deposit Maintenance')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_3()
	{
		xpath = "//*[text()[contains(.,'Maintain Deposit Reason')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_4()
	{
		xpath = "//input[contains(@value,'New')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_5()
	{
		xpath = "//input[@name='maintdepreasonform:deposit_reason_code']";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//input[@name='maintdepreasonform:deposit_reason_code']";
		passed = tsa.sendDatatoField(xpath, depReasonCode); //TODO Add Random value generation for  deposit reason code
		
		xpath = "//input[@name='maintdepreasonform:description']";
		passed = tsa.sendDatatoField(xpath, "Test Auto CC");
		
		xpath = "//input[@name='maintdepreasonform:refund_duration_mths']";
		passed = tsa.sendDatatoField(xpath, "1");
		
		xpath = "//input[@id='maintdepreasonform:auto_refund_ceased_accs_ind:_2']";
		passed = tsa.clickOn(xpath);
		
		xpath = "//input[contains(@id,'maintdepreasonform:interest_credit_bill_txtbox')]";
		passed = tsa.clearInputField(xpath);
		
		xpath = "//input[contains(@id,'maintdepreasonform:interest_credit_bill_txtbox')]";
		passed = tsa.sendDatatoField(xpath, "Y");
		
		xpath = "//input[contains(@value,'Accept')]";
		passed = tsa.clickOn(xpath);
		
		tsa.keyPress(KeyEvent.VK_PAGE_UP);
		
		return passed;
	}
	
	public boolean testStep_6()
	{
		xpath = "//*[text()[contains(.,'uccessfully')]]";
		passed = tsa.waitUntilshort(xpath);
		
		return passed;
	}
}
