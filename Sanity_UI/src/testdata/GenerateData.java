package testdata;

import java.math.BigInteger;
import java.security.SecureRandom;

public class GenerateData 
{
	public static SecureRandom random = new SecureRandom();
	
	public static String depReasonCode()
	{
		String depReasonCode	= TestData.depReasonCode;
		String charPrefix		= depReasonCode.substring(0,1);
		int intSuffix;
		
		intSuffix = Integer.parseInt(depReasonCode.substring(1));
		
		if(intSuffix == 999)
		{
			intSuffix = 0;	
			//TODO Increment the charPrefix Character by 1
		}
		else
		{
			intSuffix = intSuffix + 1;
		}
		
		depReasonCode = charPrefix + intSuffix;
		
		TestData.props.setProperty("depReasonCode", depReasonCode);
		TestData.saveChangestoConfigFile();
		
		return depReasonCode;
	}
	
	public static String CUGid()
	{
		String CUGid			= TestData.CUGid;
		String charPrefix		= "00CUG";
		int intSuffix;
		
		intSuffix = Integer.parseInt(CUGid.substring(5));
		
		if(intSuffix == 999999)
		{
			intSuffix = 0;	
		}
		else
		{
			intSuffix = intSuffix + 1;
		}
		
		CUGid = charPrefix + intSuffix;
		TestData.props.setProperty("CUGid", CUGid);
		TestData.saveChangestoConfigFile();
		
		return CUGid;
	}
	
	public static String customerID()
	{
		String customerID			= TestData.customerID;
		String charPrefix			= "TEST";
		int intSuffix;
		
		intSuffix = Integer.parseInt(customerID.substring(4));

		if(intSuffix == 99999999)
		{
			intSuffix = 0;	
		}
		else
		{
			intSuffix = intSuffix + 1;
		}
		
		customerID = charPrefix + intSuffix;
		TestData.props.setProperty("customerID", customerID);
		TestData.saveChangestoConfigFile();
		
		return customerID;
	}
	
	public static String customerFirstname()
	{
		String customerFirstname		= TestData.customerFirstname;
		
		customerFirstname = new BigInteger(130, random).toString(32);
		customerFirstname = customerFirstname.substring(0,12);
		
		TestData.props.setProperty("customerFirstname", customerFirstname);
		TestData.saveChangestoConfigFile();
		
		return customerFirstname;
	}
	
	public static String customerSurname()
	{
		String customerSurname			= TestData.customerSurname;
		
		customerSurname = new BigInteger(130, random).toString(32);
		customerSurname = customerSurname.substring(0,12);
		
		TestData.props.setProperty("customerSurname", customerSurname);
		TestData.saveChangestoConfigFile();
		
		return customerSurname;
	}
}
