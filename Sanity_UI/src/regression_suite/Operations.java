package regression_suite;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JLabel;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import application_ui.MainWindow;
import testdata.TestData;

public class Operations 
{
	public static WebDriver driver = Operations.initDriver();
	public static WebDriverWait longWait;// = new WebDriverWait(driver, 120);
	public static WebDriverWait shortWait;// = new WebDriverWait(driver,5);
	public static WebDriverWait tinyWait;// = new WebDriverWait(driver,2);
	
	public static WebDriver initDriver()
	{
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		longWait = new WebDriverWait(driver, 120);
		shortWait = new WebDriverWait(driver,5);
		tinyWait = new WebDriverWait(driver,2);
		
		return driver;
	}
	
	public static void waitFor(long time)
	{
		try 
		{
			Thread.sleep(time);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void keyPress(int keycode)
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
	
	public static void writetoUIconsole(String message)
	{
		MainWindow.consoleArea.append("\n"+message);
		MainWindow.consoleArea.revalidate();
	}

	public static void takeScreenshot()
	{
		String filename = TestConfiguration.scenarioName + "_" +String.valueOf(TestConfiguration.screenShotCount);
		String location = TestData.reportLocation + filename + ".png";
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		try 
		{
			org.apache.commons.io.FileUtils.copyFile(screenshot, new File(location));
			TestConfiguration.screenShotCount = TestConfiguration.screenShotCount + 1;
		}
		catch (IOException e) 
		{
			writetoUIconsole("Not able to save screenshot for " + filename + " in " + location);
			e.printStackTrace();
		}

		writetoUIconsole(" - Took Screenshot : " + filename);
	}
	
	public static void initReportLocation()
	{
		File file = new File(TestData.parentDir);
		if (!file.exists()) 
		{
		    writetoUIconsole("Creating Report Directory: " + TestData.reportLocation);
		    boolean result = false;

		    try
		    {
		    	file.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se)
		    {
		        //handle it
		    }        
		    if(result) 
		    {
		        writetoUIconsole("Parent Directory created");  
		    }
		}
		
		file = new File(TestData.reportLocation);
		//Check for parent directory
		if (!file.exists()) 
		{
		    writetoUIconsole("Creating Report Directory: " + TestData.reportLocation);
		    boolean result = false;

		    try
		    {
		    	file.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se)
		    {
		        //handle it
		    }        
		    if(result) 
		    {
		        writetoUIconsole("Parent Directory created");  
		    }
		}
		else
		{
			writetoUIconsole("Initialized Parent Directory..");
		}
	
		TestData.reportLocation = TestData.reportLocation + TestData.currentBuild + "\\";
		
		writetoUIconsole(TestData.reportLocation);
		
		file = new File(TestData.reportLocation);
		if (!file.exists()) 
		{
		    writetoUIconsole("Creating Report Directory: " + TestData.reportLocation);
		    boolean result = false;

		    try
		    {
		    	file.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se)
		    {
		        //handle it
		    }        
		    if(result) 
		    {
		        writetoUIconsole("Report Directory created");  
		    }
		}
		else
		{
			writetoUIconsole("Initialized Reports Directory..");
		}
	}
	
	public static void setTestStatusColor(JLabel label)
	{
		if (label.getText() == "Passed")
		{
			label.setForeground(Color.GREEN);
		}
		else if (label.getText() == "Failed")
		{
			label.setForeground(Color.RED);
		}
		else
		{
			label.setForeground(Color.BLACK);
		}
	}
}
