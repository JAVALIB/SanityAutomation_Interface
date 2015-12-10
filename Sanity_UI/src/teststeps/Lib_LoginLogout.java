package teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import regression_suite.Operations;
import regression_suite.TestStepActions;
import testdata.TestData;
import application_ui.MainWindow;

public class Lib_LoginLogout 
{
	static WebDriverWait longWait = Operations.longWait;
	static WebDriver driver = Operations.driver;
	static TestStepActions tsa = new TestStepActions();
	
	static String xpath = "";
	
	public static void Lib_Login(String autURL)
	{
		try
		{
			driver.get(autURL);
		}
		catch(UnreachableBrowserException e)
		{
			System.out.println("Unreachable Browser. Starting new chromedriver instance");
			Operations.driver = Operations.initDriver();
			
			driver = Operations.driver;

			driver.get(autURL);
		}
		
		boolean needToLogin = driver.findElements(By.id("login:userName")).size() != 0;
		boolean loggedIn = driver.findElements(By.id("headerForm:headerLogoutLink")).size() != 0;
		
		if (needToLogin)
		{
			driver.findElement(By.id("login:userName")).sendKeys("libadmin");
			driver.findElement(By.id("login:userPassword")).sendKeys("Ic3cr34m!");	
			driver.findElement(By.id("login:login_button")).click();

			xpath = "//*[text()[contains(.,'Logout')]]";
			tsa.waitUntil(xpath);
			Operations.writetoUIconsole("Logged in");
			
			TestData.currentBuild = driver.findElement(By.xpath("(//span[contains(@id,'headerForm')])[5]")).getText();
			TestData.currentBuild = TestData.currentBuild.substring(34, 37);
			
			MainWindow.current_BuildNumber.setText(TestData.currentBuild);
			
			Operations.initReportLocation();
		}
		else if (loggedIn)
		{
			Operations.writetoUIconsole("Already logged in");
		}
		else
		{
			Operations.writetoUIconsole("Not able to log in");
		}
	}
	
	public void sanity_Logout()
	{
		longWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headerForm:headerLogoutLink")));
		driver.findElement(By.id("headerForm:headerLogoutLink")).click();
		longWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login:userName")));
	}
	
	public static void Lib_LogoutExit()
	{
		driver.close();
		driver.quit();
		
		MainWindow.btnClearClose.setText("Clear");
		MainWindow.btnExecute.setEnabled(true);
	}
}

