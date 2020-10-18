package common_Framework_Functions;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseUtil {
	public WebDriver driver;
	public ExtentReports extent;
	public static ExtentTest scenarioDef;
	public static ExtentTest feature;
	public static String reportLocation;
	
}
