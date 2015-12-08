package regression_suite;

public class TestConfiguration 
{
	public static final int tsExceptionRetryCount = 5;
	
	public static String scenarioName;
	public static boolean testStatus;
	public static int screenShotCount;
	
	public static void resetConfiguration()
	{
		scenarioName = "";
		screenShotCount = 0;
		testStatus = true;
	}
}
