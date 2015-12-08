package testdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import regression_suite.Operations;
import regression_suite.SanitySuite;

public class TestData 
{
	//Build Data
	public static String currentBuild;
	public static String parentDir;
	public static String reportLocation;
	
	//Test Data
	public static String URL_13BT;
	public static String URL_14AT;
	public static String URL_13BT_ComOne;
	public static String URL_14AT_ComOne;
	public static String username;
	public static String password;
	public static String Department;
	public static String Site;
	public static String servPack_13BT;
	public static String servPack_14AT;
	public static String customerID;
	public static String customerSurname;
	public static String customerFirstname;
	public static String AccNumber14AT;
	public static String AccNumber13BT;
	public static String AccNumber14AT_ComOne;
	public static String AccNumber13BT_ComOne;
	public static String AccountNumber;
	public static String AccountNumber_ComOne;
	public static String ServiceNumber;
	public static String provSONumber;
	public static String ServiceNumber13BT_ComOne;
	public static String ServiceNumber14AT_ComOne;
	public static String ServiceNumber_ComOne;
	public static String comService_13BT;
	public static String comService_14AT;
	public static String ExchID;
	public static String NumArea;
	public static String depReasonCode;
	public static String asnSONumber;
	public static String CUGid;
	public static String ceaseSONumber;
	
	public static Properties props = new Properties();
	
	public static boolean initializeConfigFile() 
	{
		Operations.writetoUIconsole("Initializing Properties file.");
		File f = new File("config.properties");
		if(f.exists() && !f.isDirectory())	
		{
			try
			{
				FileReader reader = new FileReader("config.properties");
				props.load(reader);
				checkProperties();
			}
			catch(FileNotFoundException fe)
			{
				Operations.writetoUIconsole("Config file not found");
				fe.printStackTrace();
			}
			catch(IOException ie)
			{
				Operations.writetoUIconsole("IO Error");
				ie.printStackTrace();
			}
		}
		else
		{
			try 
			{
				f.createNewFile();
				checkProperties();
			}
			catch (IOException e) 
			{
				Operations.writetoUIconsole("Not Able to create properties file..");
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public static void checkProperties() throws IOException
	{
		Operations.writetoUIconsole("Checking properties.");
		
		String property;
		Boolean corrected = false;
		
		FileReader reader = null;
		reader = new FileReader("config.properties");
		props.load(reader);
		
		//Checking existence of properties and creates if doesn't exists
		property = null;
		property = props.getProperty("13BTURL");
		if (property == null)
		{
			props.setProperty("13BTURL", "https://liberate.cwihq.cwigintra.com/liberate-LONI01-S10/");
			corrected = true;
		}
		
		property = null;
		property = props.getProperty("14ATURL");
		if (property == null)
		{
			props.setProperty("14ATURL", "https://liberate.cwihq.cwigintra.com/liberate-LONI01-S12/");
			corrected = true;
		}
		
		property = null;
		property = props.getProperty("userName");
		if (property == null)
		{
			props.setProperty("userName", "libadmin");
			corrected = true;
		}
		
		property = null;
		property = props.getProperty("password");
		if (property == null)
		{
			props.setProperty("password", "Ic3cr34m!");
			corrected = true;
		}
		
		property = null;
		property = props.getProperty("Reports_13BT");
		if (property == null)
		{
			props.setProperty("Reports_13BT", "D:\\SanityAutomation\\Reports_13BT\\");
			corrected = true;
		}
		
		property = null;
		property = props.getProperty("Reports_14AT");
		if (property == null)
		{
			props.setProperty("Reports_14AT", "D:\\SanityAutomation\\Reports_14AT\\");
			corrected = true;
		}
		
		property = null;
		property = props.getProperty("defDepartment");
		if (property == null)
		{
			props.setProperty("defDepartment", "AQSAL");
			corrected = true;
		}
		
		property = null;
		property = props.getProperty("defSite");
		if (property == null)
		{
			props.setProperty("defSite", "SATV");
			corrected = true;
		}
		
		property = null;
		property = props.getProperty("servPack_13BT");
		if (property == null)
		{
			props.setProperty("servPack_13BT", "LIME_POST");
			corrected = true;
		}
		
		property = null;
		property = props.getProperty("servPack_14AT");
		if (property == null)
		{
			props.setProperty("servPack_14AT", "LIME_PCL_N");
			corrected = true;
		}
		
		if (corrected)
		{
			Operations.writetoUIconsole("Added missing properties in file");
		}
		else
		{
			Operations.writetoUIconsole("Properties check PASSED");
		}
		//Saving properties file
		saveChangestoConfigFile();
	}
	
	public static void loadProperties_Regression()
	{
		Operations.writetoUIconsole("Loading Properties");
		
		URL_13BT 			= props.getProperty("13BTURL");
		URL_14AT			= props.getProperty("14ATURL");
		URL_13BT_ComOne		= props.getProperty("13BTComOneURL");
		URL_14AT_ComOne		= props.getProperty("14ATComOneURL");
		
		username			= props.getProperty("userName");
		password			= props.getProperty("password");
		Department			= props.getProperty("defDepartment");
		Site				= props.getProperty("defSite");
		servPack_13BT		= props.getProperty("servPack_13BT");
		servPack_14AT		= props.getProperty("servPack_14AT");
		
		customerID			= props.getProperty("customerID");
		customerSurname		= props.getProperty("customerSurname");
		customerFirstname	= props.getProperty("customerFirstname");
		
		AccNumber14AT		= props.getProperty("AccNumber14AT");
		AccNumber13BT		= props.getProperty("AccNumber13BT");
		
		AccNumber13BT_ComOne= props.getProperty("AccNumber13BT_ComOne");
		AccNumber14AT_ComOne= props.getProperty("AccNumber14AT_ComOne");
		
		ServiceNumber13BT_ComOne = props.getProperty("ServiceNumber13BT_ComOne");
		ServiceNumber14AT_ComOne = props.getProperty("ServiceNumber14AT_ComOne");
		
		ServiceNumber		= props.getProperty("ServiceNumber");
		CUGid				= props.getProperty("CUGid");
		ExchID				= props.getProperty("ExchID");
		
		depReasonCode		= props.getProperty("depReasonCode");
		
		parentDir			= props.getProperty("parentDir"); 
		reportLocation		= props.getProperty("Reports_13BT");
		Operations.writetoUIconsole("Properties loaded");
	}
	
	public static void loadProperties_Sanity()
	{
		Operations.writetoUIconsole("Loading Properties");
		
		URL_13BT 			= props.getProperty("13BTURL");
		URL_14AT			= props.getProperty("14ATURL");
		URL_13BT_ComOne		= props.getProperty("13BTComOneURL");
		URL_14AT_ComOne		= props.getProperty("14ATComOneURL");
		
		username			= props.getProperty("userName");
		password			= props.getProperty("password");
		servPack_13BT		= props.getProperty("servPack_13BT");
		servPack_14AT		= props.getProperty("servPack_14AT");
		
		customerID			= props.getProperty("customerID");
		customerSurname		= props.getProperty("customerSurname");
		customerFirstname	= props.getProperty("customerFirstname");
		
		AccNumber14AT		= props.getProperty("AccNumber14AT");
		AccNumber13BT		= props.getProperty("AccNumber13BT");
		
		AccNumber13BT_ComOne= props.getProperty("AccNumber13BT_ComOne");
		AccNumber14AT_ComOne= props.getProperty("AccNumber14AT_ComOne");
		
		ServiceNumber13BT_ComOne = props.getProperty("ServiceNumber13BT_ComOne");
		ServiceNumber14AT_ComOne = props.getProperty("ServiceNumber14AT_ComOne");
		
		ServiceNumber		= props.getProperty("ServiceNumber");
		CUGid				= props.getProperty("CUGid");
		ExchID				= props.getProperty("ExchID");

		depReasonCode		= props.getProperty("depReasonCode");
		
		parentDir			= props.getProperty("Sanity_parentDir");
		
		Operations.writetoUIconsole("Properties loaded");
	}
	
	public static void getSanityReportLocation()
	{
		if(SanitySuite.autURL == TestData.URL_14AT)
		{
			reportLocation		= props.getProperty("Sanity_Reports_14AT");
			AccountNumber		= AccNumber14AT;
			Department			= props.getProperty("defDepartment14AT");
			Site				= props.getProperty("defSite14AT");
		}
		else if(SanitySuite.autURL == TestData.URL_13BT)
		{
			reportLocation		= props.getProperty("Sanity_Reports_13BT");
			AccountNumber		= AccNumber13BT;
			Department			= props.getProperty("defDepartment13BT");
			Site				= props.getProperty("defSite13BT");
		}	
	}
	
	public static void saveChangestoConfigFile()
	{
		try
		{
			FileWriter writer = new FileWriter("config.properties");
			TestData.props.store(writer, "automation settings");
			writer.close();
		}
		catch(IOException ie)
		{
			Operations.writetoUIconsole("\tIOException occured while writing config file.");
		}
	}

}
