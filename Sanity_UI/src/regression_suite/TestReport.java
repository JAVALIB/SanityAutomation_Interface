package regression_suite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import testdata.TestData;

public class TestReport 
{
	static XWPFDocument doc;
	static String documentName;
	static String wordDoc;
    static FileOutputStream fos = null;
    static int scrnCount;
    
	public static void initialize()
	{
		doc = new XWPFDocument();
		documentName = TestConfiguration.scenarioName;
		wordDoc = TestData.reportLocation + documentName;
		scrnCount = TestConfiguration.screenShotCount;
	}
	
	public static void createScreenshotDocument()
	{
		initialize();
		
	    XWPFParagraph para = doc.createParagraph();    
	    XWPFRun run = para.createRun();
	    
		try 
		{
			fos = new FileOutputStream(wordDoc + ".docx");
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("\t"+ wordDoc + ".docx NOT FOUND.");
		}

	    for (int i = 0; i < scrnCount; i++)
	    {
			String imgFile = TestData.reportLocation + documentName + "_" + (i) + ".png";
					
			File file = new File(imgFile);
		    
			try 
			{
				FileInputStream is = new FileInputStream(imgFile);
				run.addBreak();
			    run.addPicture(is, XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(540), Units.toEMU(303)); //720 x 405 - 16:9
			    is.close();
			    file.delete();
			} 
			catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (InvalidFormatException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
	    }
	    
	    try 
	    {
			doc.write(fos);
		    fos.close();   
		}
	    catch (IOException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Created Document " + documentName + ".docx");
		//TODO add create screenshot document code
	}
	
	static String getPassedFailed(Boolean bool)
	{
		if (bool)
			return "Passed";
		else
			return "Failed";
	}
}
