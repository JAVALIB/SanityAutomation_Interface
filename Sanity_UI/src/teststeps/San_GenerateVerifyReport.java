package teststeps;

import org.openqa.selenium.support.ui.WebDriverWait;

import regression_suite.Operations;
import regression_suite.TestStepActions;

public class San_GenerateVerifyReport
{
	static WebDriverWait longWait = Operations.longWait;

	TestStepActions tsa = new TestStepActions();
	
	String xpath	= "";
	String serverDate;
	boolean passed	= true;
	
	public boolean testStep_1()
	{
		xpath = "//a[contains(@href,'maintainEmployeeParams.xhtml')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_2()
	{
		xpath = "//*[text()[contains(.,'Withdrawn Items')]]";
		
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_3()
	{
		xpath = "//*[text()[contains(.,'Suspense by Exchange')]]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_4()
	{
		xpath = "//select[contains(@id,'exchangeID')]";
		passed = tsa.waitUntil(xpath);
		tsa.selectBy(xpath, 3);
		
		xpath = "//select[contains(@id,'suspenseReason')]";
		tsa.selectBy(xpath, "AIMSIS");
		
		xpath = "//input[@value = 'Accept']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_5()
	{
		xpath = "//*[text()[contains(.,'uccessfully')]]";
		passed = tsa.waitUntil(xpath);

		xpath = "(//*[@class = 'blackNormal'])[2]";
		serverDate = tsa.getDatafromPage(xpath);
	
		serverDate = serverDate.replaceAll("/", "-");
		serverDate = serverDate.replaceAll(",", "");
			
		tsa.waitUntil(xpath);
		
		return passed;
	}
	
	public boolean testStep_6()
	{
		xpath = "//*[text()[contains(.,'Home')]]";
		passed = tsa.clickOn(xpath);
		
		return true;
	}
	
	public boolean testStep_7()
	{
		xpath = "//*[text()[contains(.,'Reports')]]";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_8()
	{
		xpath = "//input[contains(@id,'reportno')]";
		passed = tsa.waitUntil(xpath);
		passed = tsa.sendDatatoField(xpath, "CIR394G02");
		
		xpath = "//input[@value = 'Search']";
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_9()
	{
		
		xpath = "//tr[@id='browseReports:reportsTable_row_0']";
		passed = tsa.waitUntil(xpath);
		passed = tsa.clickOn(xpath);
		
		return passed;
	}
	
	public boolean testStep_10()
	{
		xpath = "//*[text()[contains(.,'Available Reports')]]";
		passed = tsa.waitUntil(xpath);
		
		xpath = "//*[text()[contains(.,'" + serverDate + "')]]";
		
		boolean reportExist = tsa.elementExist(xpath);
		
		if(reportExist)
		{
		xpath = "(//a[contains(@id,'reportsDataTable:')])[1]";
		passed = tsa.clickOn(xpath);
		Operations.waitFor(1000);
				
				//Operations.waitForNumberOfWindowsToEqual(2);//this method is for wait
				
				//NOT MY CODE
//				Set<String> handles = driver.getWindowHandles();
//				 
//				String firstWinHandle = driver.getWindowHandle();
//				handles.remove(firstWinHandle);
//				 
//				Object winHandle=handles.iterator().next();
//				 
//				if (winHandle!=firstWinHandle)
//				{
					//To retrieve the handle of second window, extracting the handle which does not match to first window handle
//					String secondWinHandle = (String) winHandle; //Storing handle of second window handle
					//Switch control to new window
//					driver.switchTo().window(secondWinHandle);
//				}
//				for (String handle : driver.getWindowHandles()) 
//				{
//					driver.switchTo().window(handle);
//				}
//			}
		}
		else
		{
			Operations.writetoUIconsole("CIR394G02 Report is not generated..");
			passed = false;
		}
		
		return passed;
	}
}
