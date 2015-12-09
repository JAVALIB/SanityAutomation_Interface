package teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import regression_suite.Operations;
import testdata.TestData;

public class Lib_LoginLogout 
{
	static WebDriverWait longWait = Operations.longWait;
	static WebDriver driver = Operations.driver;

	public static void Lib_Login(String autURL)
	{
		try
		{
			driver.get(autURL);
		}
		catch(UnreachableBrowserException e)
		{
			System.out.println("Unreachable Browser. Starting new chromedriver instance");
			driver = Operations.initDriver();
			driver.get(autURL);
		}
		
		boolean needToLogin = driver.findElements(By.id("login:userName")).size() != 0;
		boolean loggedIn = driver.findElements(By.id("headerForm:headerLogoutLink")).size() != 0;
		
		if (needToLogin)
		{
			driver.findElement(By.id("login:userName")).sendKeys("libadmin");
			driver.findElement(By.id("login:userPassword")).sendKeys("Ic3cr34m!");	
			driver.findElement(By.id("login:login_button")).click();
//			longWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(@id,'headerForm')])[5]")));
			longWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()[contains(.,'Logout')]]")));
			Operations.writetoUIconsole("Logged in");
			
			TestData.currentBuild = driver.findElement(By.xpath("(//span[contains(@id,'headerForm')])[5]")).getText();
			TestData.currentBuild = TestData.currentBuild.substring(34, 37);
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
		driver.quit();
	}
}

