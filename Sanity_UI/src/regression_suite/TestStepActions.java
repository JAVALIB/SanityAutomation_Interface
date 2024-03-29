package regression_suite;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import application_ui.MainWindow;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class TestStepActions 
{
	int i;
	int retry = TestConfiguration.tsExceptionRetryCount;
	boolean passed = true;
	
//	static WebDriverWait longWait = Operations.longWait;
//	static WebDriverWait shortWait = Operations.shortWait;
//	static WebDriverWait tinyWait = Operations.tinyWait;

//	static WebDriver driver = Operations.driver;
	
	static String AccountNumber;
	static String ServiceNumber;
	static String ServiceOrderNumber;
	
	public boolean clickOn(String xpath)
	{
		for(int i=0;i<retry;i++)
		{
			Operations.waitFor(200);
			try
			{
				MainWindow.writetoUIconsole("\tClicking on :" + xpath);
				Operations.driver.findElement(By.xpath(xpath)).click();
				break;
			}
			catch(StaleElementReferenceException se)
			{
				MainWindow.writetoUIconsole("\tStaleElementReferenceException Occured - While clicking on '"+xpath+"' . Retrying");
			}
			catch(ElementNotVisibleException nv)
			{
				MainWindow.writetoUIconsole("\tElementNotVisibleException Occured - While clicking on '"+xpath+"' . Retrying");				
			}
			catch(ElementNotFoundException nf)
			{
				MainWindow.writetoUIconsole("\tElementNotFoundException Occured - While clicking on '"+xpath+"' . Retrying");
			}
			catch(NoSuchElementException se)
			{
				MainWindow.writetoUIconsole("\nNoSuchElementException Occured - While clicking on '"+xpath+"' . Exiting");
				passed = false;
				break;
			}
			catch(WebDriverException we)
			{
				we.printStackTrace();
				MainWindow.writetoUIconsole("\tWebDriverException Occured- While clicking on '"+xpath+"' . Retrying");
			}
		}
		
		return passed;
	}
	
	public boolean sendDatatoField(String xpath, String value)
	{
		for(int i=0;i<retry;i++)
		{
			try
			{
				MainWindow.writetoUIconsole("\tSending data '" + value + "' to field : " + xpath);
				clearInputField(xpath);
				Operations.driver.findElement(By.xpath(xpath)).sendKeys(value);
				break;
			}
			catch(StaleElementReferenceException se)
			{
				MainWindow.writetoUIconsole("\tStaleElementReferenceException Occured - While sending data to '"+xpath+"' . Retrying");
			}
			catch(ElementNotVisibleException nv)
			{
				MainWindow.writetoUIconsole("\tElementNotVisibleException Occured - While sending data to '"+xpath+"' . Retrying");				
			}
			catch(ElementNotFoundException nf)
			{
				MainWindow.writetoUIconsole("\tElementNotFoundException Occured - While sending data to '"+xpath+"' . Exiting");
			}
			catch(NoSuchElementException se)
			{
				MainWindow.writetoUIconsole("\nNoSuchElementException Occured- While sending data to '"+xpath+"' . Exiting");
				passed = false;
				break;
			}
		}
		if (i == 4)
			passed = false;
		
		return passed;	
	}
	
	public String getDatafromPage(String xpath)
	{
		String dataFromPage = "";
		
		MainWindow.writetoUIconsole("\tGetting value from : " + xpath);
		dataFromPage = Operations.driver.findElement(By.xpath(xpath)).getText();
		
		return dataFromPage;
	}
	
	public boolean clearInputField(String xpath)
	{
		for(int i=0;i<retry;i++)
		{
			try
			{
				Operations.driver.findElement(By.xpath(xpath)).clear();
				break;
			}
			catch(StaleElementReferenceException se)
			{
				MainWindow.writetoUIconsole("\tStaleElementReferenceException Occured - While clearing '"+xpath+"' . Retrying");
			}
			catch(ElementNotVisibleException nv)
			{
				MainWindow.writetoUIconsole("\tElementNotVisibleException Occured - While clearing '"+xpath+"' . Retrying");				
			}
			catch(ElementNotFoundException nf)
			{
				MainWindow.writetoUIconsole("\tElementNotFoundException Occured - While clearing '"+xpath+"' . Exiting");
			}
			catch(NoSuchElementException se)
			{
				MainWindow.writetoUIconsole("\nNoSuchElementException Occured - While clearing '"+xpath+"' . Exiting");
				passed = false;
				break;
			}
		}
		if (i == 4)
			passed = false;
		
		return passed;	
	}
	
	public boolean waitUntil(String xpath)
	{
		for(int i=0;i<retry;)
		{
			try
			{
				MainWindow.writetoUIconsole("\tWaiting for : " + xpath);
				Operations.longWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				passed = true;
				break;
			}
			catch(TimeoutException se)
			{
				MainWindow.writetoUIconsole("\tTimeoutException Occured while waiting for '"+xpath+"'. Exiting");
				passed = false;
				break;
			}
		}
		return passed;	
	}
	
	public boolean waitUntiltiny(String xpath)
	{
		for(int i=0;i<retry;)
		{
			try
			{
				MainWindow.writetoUIconsole("\tWaiting for : " + xpath);
				Operations.tinyWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				break;
			}
			catch(TimeoutException se)
			{
				MainWindow.writetoUIconsole("\tTimeoutException Occured while waiting for '"+xpath+"'. Exiting");
				passed = false;
				break;
			}
		}
		return passed;
	}
	
	public boolean waitUntilshort(String xpath)
	{
		for(int i=0;i<retry;)
		{
			try
			{
				MainWindow.writetoUIconsole("\tWaiting for : " + xpath);
				Operations.shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				break;
			}
			catch(TimeoutException se)
			{
				MainWindow.writetoUIconsole("\tTimeoutException Occured while waiting for '"+xpath+"'. Exiting");
				passed = false;
				break;
			}
		}
		return passed;
	}

	
	public boolean waitUntilElementnotExist(String xpath, int time)
	{
		for(int i=0;i<retry;i++)
		{
			if(elementExist(xpath))
			{
				Operations.waitFor(time);
			}
			else
			{
				passed = true;
				break;
			}
		}
		return passed;
	}

	public boolean elementExist(String xpath)
	{
		return(Operations.driver.findElements(By.xpath(xpath)).size() != 0);
	}
	
	public void closeOKpopup()
	{
		try 
		{
			Operations.waitFor(500);
			if (Operations.driver.findElements(By.xpath("//input[contains (@value,'OK')]")).size() != 0)
			{
				testcases.Check.closeError();
			}
			Operations.waitFor(500);
			if (Operations.driver.findElements(By.xpath("//input[contains (@value,'OK')]")).size() != 0)
			{
				try
				{
				testcases.Check.closeError();
				}
				catch(Exception e)
				{
					//DO NOTHING
				}
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean selectBy(String xpath, String value)
	{
		for(int i=0;i<retry;i++)
		{
			try
			{
				MainWindow.writetoUIconsole("\tSelecting value'" + value +"' from : " + xpath);
				Select appForm = new Select(Operations.driver.findElement(By.xpath(xpath)));
				appForm.selectByValue(value);
				break;
			}
			catch(StaleElementReferenceException se)
			{
				MainWindow.writetoUIconsole("\tStaleElementReferenceException Occured while selecting '"+value+"' from '"+xpath+"'. Retrying");
			}
			catch(ElementNotVisibleException nv)
			{
				MainWindow.writetoUIconsole("\tElementNotVisibleException Occured while selecting '"+value+"' from '"+xpath+"'. Retrying");				
			}
			catch(ElementNotFoundException nf)
			{
				MainWindow.writetoUIconsole("\tElementNotFoundException Occured while selecting '"+value+"' from '"+xpath+"'. Exiting");
			}
			catch(NoSuchElementException se)
			{
				MainWindow.writetoUIconsole("\nNoSuchElementException Occured while selecting '"+value+"' from '"+xpath+"'. Exiting");
				passed = false;
				break;
			}
		}
		
		if (i == 4)
			passed = false;
		
		return passed;
	}
	
	public boolean selectBy(String xpath, int index)
	{
		for(int i=0;i<retry;i++)
		{
			try
			{
				MainWindow.writetoUIconsole("\tSelecting index'" + index +"' from : " + xpath);
				Select appForm = new Select(Operations.driver.findElement(By.xpath(xpath)));
				appForm.selectByIndex(index);
				break;
			}
			catch(StaleElementReferenceException se)
			{
				MainWindow.writetoUIconsole("\tStaleElementReferenceException Occured while selecting index '"+index+"' from '"+xpath+"'. Retrying");
			}
			catch(ElementNotVisibleException nv)
			{
				MainWindow.writetoUIconsole("\tElementNotVisibleException Occured while selecting index '"+index+"' from '"+xpath+"'. Retrying");				
			}
			catch(ElementNotFoundException nf)
			{
				MainWindow.writetoUIconsole("\tElementNotFoundException Occured while selecting index '"+index+"' from '"+xpath+"'. Retrying");
			}
			catch(NoSuchElementException se)
			{
				MainWindow.writetoUIconsole("\nNoSuchElementException Occured while selecting index '"+index+"' from '"+xpath+"'. Exiting");
				passed = false;
				break;
			}
		}
		if (i == 4)
			passed = false;
		
		return passed;
	}
	
	public void keyPress(int keycode)
	{
		Robot robot;
		try 
		{
			robot = new Robot();
			robot.keyPress(keycode);
			robot.keyRelease(keycode);
		}
		catch (AWTException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void mouseMove(int x,int y)
	{
		Robot robot = null; 
		try { 
			robot = new Robot(); 
			robot.mouseMove(x,y);
		} catch (AWTException e)
		{ 
			e.printStackTrace();
		} 
	}
	
	public void scrollUp()
	{
		JavascriptExecutor jse = (JavascriptExecutor)Operations.driver;
		jse.executeScript("window.scrollBy(0,-2000)", "");
	}

}
