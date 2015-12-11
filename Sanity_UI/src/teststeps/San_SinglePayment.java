package teststeps;

import org.openqa.selenium.support.ui.WebDriverWait;

import regression_suite.Operations;
import regression_suite.TestStepActions;

public class San_SinglePayment 
{
	static WebDriverWait longWait = Operations.longWait;

	TestStepActions tsa = new TestStepActions();
	
	static String cashierDepartment = "CASH";
	static String backUpcashierDepartment = "CASH1";

	static String accountNumber = "240004430000";
	static String paymentType = "S";
	static String paymentMethod = "C";
	static String tenderAmount = "100.00";
	
	String xpath	= "";
	boolean passed	= true;
	
	public boolean testStep_1() 
	{
		xpath = "//*[text()[contains(.,'rders')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_2()
	{
		xpath = "//input[contains(@value,'hange')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		xpath = "//select[@disabled='disabled']";
		passed = tsa.waitUntilElementnotExist(xpath, 1800);
		
		xpath = "(//select[contains(@class,'iceSelOneMnu')])[1]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.selectBy(xpath, cashierDepartment);
		
		Operations.waitFor(1000);
		
		return true;
	}
	
	public boolean testStep_3()
	{
		Operations.waitFor(1000);
		
		xpath = "//*[text()[contains(.,'Payments')]]";
		passed = tsa.clickOn(xpath);
		
		xpath = "//*[text()[contains(.,'Single Payment')]]/./following::span[contains(@class,'iceOutTxt')]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//*[text()[contains(.,'Cashdrawer already open in another office.')]]"; 
		if(tsa.elementExist(xpath))
		{
			tsa.closeOKpopup();
			
			xpath = "//div[contains(@style,'transparent')]";
			tsa.waitUntilElementnotExist(xpath, 500);
			
			if(!(cashierDepartment == backUpcashierDepartment))
			{
				cashierDepartment = backUpcashierDepartment;
			
				testStep_1();
				testStep_2();
				testStep_3();
				
				passed = false;
			}
		}
		
		xpath = "//input[@id='singlePayment:accountNumber']";
		passed = tsa.waitUntil(xpath);
		passed= tsa.sendDatatoField(xpath, accountNumber);
		
		xpath = "//input[contains(@value,'Search')]";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_4()
	{
		xpath = "//input[contains(@value,'Accept')]";
		passed = tsa.waitUntil(xpath);

		xpath = "//select[@id='singlePayment:paymentType']";
		passed = tsa.selectBy(xpath, paymentType);

		xpath = "//select[@id='singlePayment:paymentMethod']";
		passed = tsa.selectBy(xpath, paymentMethod);
		
		xpath = "//input[@id='singlePayment:tenderAmount']";
		passed = tsa.clearInputField(xpath);
		
		xpath = "//input[@id='singlePayment:tenderAmount']";
		passed = tsa.sendDatatoField(xpath, tenderAmount);
		
		xpath = "//input[contains(@value,'Accept')]";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_5()
	{
		xpath = "//*[text()[contains(.,'tanding')]]";
		passed = tsa.waitUntil(xpath);

		xpath = "//input[contains(@value,'Accept')]";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_6()
	{
		xpath = "//*[text()[contains(.,'uccessfully')]]";
		passed = tsa.waitUntilshort(xpath);
		
		return passed;
	}
}
