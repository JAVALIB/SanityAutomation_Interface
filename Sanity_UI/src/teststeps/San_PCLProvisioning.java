package teststeps;

import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;

import regression_suite.Operations;
import regression_suite.SanitySuite;
import regression_suite.TestStepActions;
import testdata.TestData;
import application_ui.MainWindow;

public class San_PCLProvisioning 
{
	static WebDriverWait longWait = Operations.longWait;
	
	TestStepActions tsa = new TestStepActions();
	
	String xpath	= "";
	boolean passed	= true;
	
	String servPack;
//	public static final String ExchID = "GSMP";
//	public static final String NumArea = "GSPR";
	
	//13BT
	public static final String ExchID = "MSCA";
	public static final String NumArea = "SMPO";

	public static String createdAccountNumber = "";
	int i;
	boolean idEntered;
	
	public boolean testStep_1()
	{
		xpath = "//*[text()[contains(.,'Customer Care')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		//Add exception handling
		//change status to true id passed (no exception)
		return passed;
	}
	public boolean testStep_2()
	{
		xpath = "//*[text()[contains(.,'Service Provisioning')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		//Add exception handling
		//change status to true id passed (no exception)
		return passed;
	}
	public boolean testStep_3()
	{
		//choosing service package
		if (SanitySuite.autURL == TestData.URL_14AT)
		{
			servPack = TestData.servPack_14AT;
		}
		else if (SanitySuite.autURL == TestData.URL_13BT)
		{
			servPack = TestData.servPack_13BT;
		}
		
		tsa.closeOKpopup();
		Operations.waitFor(1000);
		
		xpath = "//*[contains(@class,'iceSelOneLb mandatory')]";
		passed = tsa.selectBy(xpath, "prepaidresidential");
		
		xpath = "//*[contains(@id,'selectCustomerTypeForm:spcustomerType')]";
		passed = tsa.selectBy(xpath, "R");
		Operations.waitFor(1000);
		
		xpath = "//*[contains(@id,'selectCustomerTypeForm:spserviceType')]";
		passed = tsa.selectBy(xpath, "PCL");
		Operations.waitFor(2000);
		
		xpath = "//*[contains(@id,'selectCustomerTypeForm:spservicePackage')]";
		passed = tsa.selectBy(xpath,servPack);
		Operations.waitFor(500);
		
		xpath = "//input[@value = 'Proceed >>']";
		passed = tsa.clickOn(xpath);
		
//		if (SanitySuite.autURL == TestData.URL_14AT)
		if(true)
		{
			//Code for Customer ID
			xpath = "//select[@class = 'iceSelOneLb MandatoryListBox']";
			passed = tsa.waitUntil(xpath);
			passed = tsa.selectBy(xpath,"NI");
			
			xpath = "//input[@class = 'iceInpTxt MandatoryTextBox']";
			passed = tsa.waitUntil(xpath);
			tsa.sendDatatoField(xpath, TestData.customerID);
			
			xpath = "//input[@class = 'iceCmdBtn cmdBtn marginright5']";
			passed = tsa.clickOn(xpath);
			
			xpath = "//input[@value = 'Create new account']";
			passed = tsa.waitUntil(xpath);
			passed = tsa.clickOn(xpath);

		}
		
		//change status to true id passed (no exception)
		return passed;
	}
	public boolean testStep_4()
	{
		xpath = "//select[@id='createCustomerForm:salutation']";
		passed = tsa.waitUntil(xpath);
		passed = tsa.selectBy(xpath,"MR");
		
		xpath  = "//input[@id = 'createCustomerForm:surname']";
		tsa.sendDatatoField(xpath, TestData.customerSurname);
		
		xpath = "//input[@id = 'createCustomerForm:firstName']";
		tsa.sendDatatoField(xpath, TestData.customerFirstname);
		
		xpath  = "//input[@name = 'createCustomerForm:dateOfBirth_input']";
		passed = tsa.clickOn(xpath);
		Operations.waitFor(500);
		
		xpath = "(//a[@href='#' and contains(@class,'ui-state-default')])[1]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		Operations.waitFor(500);

		xpath = "//select[@id= 'createCustomerForm:nationalityList']";
		passed = tsa.selectBy(xpath, 1);
		
		xpath = "//select[@id= 'createCustomerForm:segment']";
		if(tsa.elementExist(xpath))
		{
			passed = tsa.selectBy(xpath, "C");
		}

		xpath = "//input[contains(@id, 'createCustomerForm:billingAddress') and contains (@class, 'MandatoryTextBox')]";
		passed = tsa.sendDatatoField(xpath, "Test Address");
		
		//Part for 14AT
		if(SanitySuite.autURL == TestData.URL_14AT)
		{
			xpath = "//select[@id='createCustomerForm:billStatsArea']";
			passed = tsa.selectBy(xpath, "CCC");
			
			xpath = "//select[@id='createCustomerForm:region']";
			passed = tsa.selectBy(xpath, "ANG");
	
			Operations.waitFor(1000);
			
			xpath = "//select[@id='createCustomerForm:billStatsArea']";
			passed = tsa.selectBy(xpath, "CCC");
			
			xpath = "//select[@id='createCustomerForm:employmentStatus']";
			passed = tsa.selectBy(xpath, "1");
		}
		
		//Part for 13BT
		else if(SanitySuite.autURL == TestData.URL_13BT)
		{
			xpath = "//select[@id='createCustomerForm:companyCode']";
			passed = tsa.selectBy(xpath, 1);
			
			xpath = "//select[@id='createCustomerForm:customerType']";
			passed = tsa.selectBy(xpath, "R");
			
			xpath = "//select[@id='createCustomerForm:marketingCategoryList']";
			passed = tsa.selectBy(xpath, "990000");
			
			xpath = "//select[@id='createCustomerForm:region']";
			passed = tsa.selectBy(xpath, "CAY");
			
			xpath = "//select[@id='createCustomerForm:accountingType']";
			passed = tsa.selectBy(xpath, "TP");

			Operations.waitFor(1000);
			xpath = "//select[@id='createCustomerForm:billStatsArea']";
			passed = tsa.selectBy(xpath, "BOT");

		}
		
		//Customer ID selection (Applicable for 13BT)
//		if (SanitySuite.autURL == TestData.URL_13BT)
		if(xpath.equals("1000"))
		{
			xpath = "//select[contains(@id,'customerIDDTOList') and contains(@class,'MandatoryListBox')]";
			passed = tsa.selectBy(xpath, "NI");
			passed = tsa.waitUntil(xpath);
			
			xpath = "//input[contains(@class,'MandatoryTextBox') and contains(@id,'createCustomerForm:customerIDDTOList')]";
			passed = tsa.sendDatatoField(xpath, TestData.customerID);
		}
		
		testcases.Check.closeError();
		
		if (SanitySuite.autURL == TestData.URL_14AT)
		{
			xpath = "//input[contains(@value,'Next>>')]";
		}
		else if (SanitySuite.autURL == TestData.URL_13BT)
		{
			xpath = "(//input[contains(@value,'Next>>')])[2]";
		}
		
		passed = tsa.clickOn(xpath);
		
		//change status to true id passed (no exception)
		return passed;
	}
	public boolean testStep_5()
	{
		testcases.Check.closeError();
		
		if (SanitySuite.autURL == TestData.URL_14AT)
		{
			xpath = "//input[contains(@value,'Confirm')]";
		}
		else if (SanitySuite.autURL == TestData.URL_13BT)
		{
			xpath = "(//input[contains(@value,'Confirm')])[2]";
		}
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_6()
	{
		//change status to true id passed (no exception)
		xpath = "//*[text()[contains(.,'Account Number')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//td[contains(.,'Account Number')]/./following::span[@class='iceOutTxt'][1]";
		createdAccountNumber = tsa.getDatafromPage(xpath);
		
		MainWindow.writetoUIconsole("\tAccount Created : " + createdAccountNumber);
		
		xpath = "//select[contains(@id,'departmentCode')]";
		passed = tsa.selectBy(xpath, TestData.Department);
		
		Operations.waitFor(1000);
		
		xpath = "//select[contains(@id,'siteCode')]";
		passed = tsa.selectBy(xpath, TestData.Site);
		
		xpath = "//input[contains(@id,'noOfProvisions')]";
		passed = tsa.waitUntil(xpath);		
		
		xpath = "//input[@value = 'Proceed']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_7()
	{
		xpath = "//*[text()[contains(.,'Available Pricing Plans')]]";
		passed = tsa.waitUntil(xpath);		
		
		xpath = "//input[@value = 'Proceed']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_8()
	{
		xpath = "//*[text()[contains(.,'Service Product')]]";
		passed = tsa.waitUntil(xpath);		
		
		xpath = "//tr[contains(@id,'availableProductDetails:0')]";
		passed = tsa.clickOn(xpath);
		
		Operations.waitFor(1000);
		
		xpath = "//input[@value = 'Proceed']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_9()
	{
		if(SanitySuite.autURL == TestData.URL_14AT)
		{
//			xpath = "//input[contains(@id,'productFieldValue')]";
//			passed = tsa.waitUntil(xpath);		
//			tsa.sendDatatoField(xpath, "test@tgmail.com");
		}
		
		if(SanitySuite.autURL == TestData.URL_13BT)
		{
			xpath = "//input[@id='packageProductSelection:productFieldDetails:1:productFieldValue']";
			passed = tsa.waitUntil(xpath);		
			tsa.sendDatatoField(xpath, "TESTUID");
			
			xpath = "//input[@id='packageProductSelection:productFieldDetails:2:productFieldValue']";
			tsa.sendDatatoField(xpath, "225522");
			Operations.waitFor(500);
			
			xpath = "//input[@value = 'Proceed']";
			passed = tsa.clickOn(xpath);
		}
		
		return passed;
	}
	
	public boolean testStep_10()
	{
//		xpath = "//*[text()[contains(.,'Payment Items')]]";
//		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//		
//		driver.findElement(By.xpath("//input[@value = 'Proceed']")).click();
		
		passed = true;
		
		return passed;
	}

	public boolean testStep_11()
	{
		xpath = "//*[text()[contains(.,'Service Details')]]";
		passed = tsa.waitUntil(xpath);		
		
		xpath = "//select[contains(@id,'exchangeID')]";
		passed = tsa.selectBy(xpath, ExchID);
		
		xpath = "//select[@class = 'iceSelOneLb selectOneMenuMandatory200' and contains(@id,'numberarea')]";
		passed = tsa.waitUntil(xpath);		

		xpath = "//select[contains(@id,'numberarea')]";
		passed = tsa.selectBy(xpath, NumArea);
		
		//For Auto - manual allocation validation
		xpath = "//select[@id='serviceSelectionMobile:serviceNumberAllocationID']";
		passed = tsa.selectBy(xpath, "Auto");

		Operations.waitFor(500);
		xpath = "//input[contains(@value,'eall')]";
		
		if(tsa.elementExist(xpath))
		{
			xpath = "//input[contains(@value,'Find')]";
			passed = tsa.clickOn(xpath);
		}
		
		xpath = "//input[contains(@value,'eall')]";
		passed = tsa.waitUntil(xpath);		
		
		xpath = "(//input[@class='iceSelBoolChkbx'])[1]";
		passed = tsa.clickOn(xpath);
		Operations.waitFor(1000);
		
		xpath = "//input[contains(@value,'Look')]";
		passed = tsa.clickOn(xpath);
		
		xpath = "//*[text()[contains(.,'matching the details entered')]]";
		passed = tsa.waitUntil(xpath);		
		
		xpath = "(//input[contains(@value,'ook')]/./following::select)[1]";
		Operations.waitFor(1000);

		passed = tsa.selectBy(xpath, 7);
		Operations.waitFor(1000);
		
		xpath = "//input[@value = 'Proceed']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_12()
	{
		Operations.waitFor(1000);
		
		xpath = "//*[text()[contains(.,'wish to continue?')]]";
		if(tsa.elementExist(xpath))
		{
			testcases.Check.continuePopup();
		}
		xpath = "//*[text()[contains(.,'Contract Details')]]";
		passed = tsa.waitUntil(xpath);		
		
		xpath = "//input[@id='serviceDetailsAddtnForm:contractNumber']";
		tsa.sendDatatoField(xpath, "232111");
		
		xpath = "//textarea[@id='serviceDetailsAddtnForm:contractDescription']";
		tsa.sendDatatoField(xpath, "Test Contract");
		
		xpath = "//select[@id='serviceDetailsAddtnForm:contractDuration']";
		tsa.selectBy(xpath, 2);
		
		xpath = "//input[@value = 'Submit']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_13()
	{
		xpath = "//*[text()[contains(.,'Service Order Lines')]]";
		tsa.waitUntil(xpath);
		
		testcases.Check.closeError();

		Operations.waitFor(200);

		testcases.Check.closeError();

		xpath = "//td[contains(.,'Account Number')]/./following::span[@class='iceOutTxt'][1]";
		TestData.AccountNumber = tsa.getDatafromPage(xpath);

		xpath = "//td[contains(.,'Account Number')]/./following::span[@class='iceOutTxt'][3]";
		TestData.ServiceNumber = tsa.getDatafromPage(xpath);

		xpath = "//td[contains(.,'Account Number')]/./following::span[@class='iceOutTxt'][4]";
		TestData.provSONumber = tsa.getDatafromPage(xpath);
		
		
		MainWindow.writetoUIconsole("");
		MainWindow.writetoUIconsole("AccountNumber : " + TestData.AccountNumber);
		MainWindow.writetoUIconsole("ServiceNumber : " + TestData.ServiceNumber);
		MainWindow.writetoUIconsole("ServiceOrder  : " + TestData.provSONumber);
		
		try
		{
			if(TestData.initializeConfigFile())
			{
				if (SanitySuite.autURL == TestData.URL_14AT)
				{
					TestData.props.setProperty("AccNumber14AT", TestData.AccountNumber);
					TestData.props.setProperty("ServiceNumber", TestData.ServiceNumber);
					
					FileWriter writer = new FileWriter("config.properties");
					TestData.props.store(writer, "automation settings");
				    writer.close();
				}
				else if (SanitySuite.autURL == TestData.URL_13BT)
				{
					TestData.props.setProperty("AccNumber13BT", TestData.AccountNumber);
					TestData.props.setProperty("ServiceNumber", TestData.ServiceNumber);
					
					FileWriter writer = new FileWriter("config.properties");
					TestData.props.store(writer, "automation settings");
				    writer.close();
				}
			}
		}
		catch (IOException io)
		{
			io.printStackTrace();
		}
		
		Operations.waitFor(500);
		
		xpath = "//input[@value = 'Submit Order']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_14()
	{
		xpath ="//*[text()[contains(.,'Account Signoff')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//input[@value = 'OK']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_15()
	{
	
		xpath = "//input[@value = 'Accept']";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}

	public boolean testStep_16()
	{
		xpath = "//input[@id = 'signoffServiceOrderForm:Ok']";
		passed = tsa.waitUntil(xpath);

		xpath = "//input[@id = 'signoffServiceOrderForm:Ok']";
		passed = tsa.clickOn(xpath);
		
		Operations.waitFor(200);

		return passed;
	}
	
	public boolean testStep_17()
	{
		xpath = "//*[text()[contains(.,'Service Order List')]]";
		tsa.waitUntil(xpath);
		MainWindow.writetoUIconsole("Passed");
		
		return passed;
	}
}
