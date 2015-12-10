package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import regression_suite.Operations;
import application_ui.MainWindow;

public class Check 
{
	static WebDriverWait longWait = Operations.longWait;
	static WebDriver driver = Operations.driver;
	static String xpath;
	static String errorMsg;
	
	public static String errorOccured()
	{
		if (unknownError())
			return("unknownError");
		
		if (serverInternalError())
			return("serverInternalError");
		
		if (networkConnectionInterrupted())
			return("networkConnectionInterrupted");
		
		if (exceptionOccured())
			return("exception");

		return("");
	}
	
	public static boolean unknownError()
	{
		boolean errorOccured = false;
		
		//TODO Add check for unknownError
		errorOccured = driver.findElements(By.xpath("//*[text()[contains(.,'n unknown error has occurred')]]")).size() != 0;
		
		if (errorOccured)
			MainWindow.writetoUIconsole("An Unknown Error occured. Trying to proceed with Testing");
		
		return errorOccured;	
	}
	
	public static boolean serverInternalError()
	{
		boolean errorOccured = false;

		//TODO Add check for serverInternalError
		if (errorOccured)
			MainWindow.writetoUIconsole("Server Internal Error occured. Trying to proceed with Testing");

		return errorOccured;	
	}
	
	public static boolean networkConnectionInterrupted()
	{
		boolean errorOccured = false;

		//TODO Add check for networkConnectionInterrupted
		if (errorOccured)
			MainWindow.writetoUIconsole("Network Connection Interrupted. Trying to proceed with Testing");

		return errorOccured;
	}
	
	public static boolean exceptionOccured()
	{
		boolean errorOccured = false;
		
		xpath = "//*[text()[contains(.,'exception is')]]";
		errorOccured = driver.findElements(By.xpath(xpath)).size() != 0;
		
		errorMsg = driver.findElement(By.xpath(xpath)).getText();
		
		//TODO Add check for networkConnectionInterrupted
		if (errorOccured)
		{
			MainWindow.writetoUIconsole("\tAn Following Excpetion occured.");
			MainWindow.writetoUIconsole("\t" + errorMsg);
		}
		return errorOccured;
	}

	public static void closeError() 
	{
		xpath = "//input[contains (@value,'OK')]";
		// TODO Auto-generated method stub
		if(driver.findElements(By.xpath(xpath)).size()!=0)
			driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void continuePopup()
	{
	xpath = "//input[contains (@value,'Yes')]";
	
	// TODO Auto-generated method stub
	if(driver.findElements(By.xpath(xpath)).size()!=0)
		driver.findElement(By.xpath(xpath)).click();
	}
}
