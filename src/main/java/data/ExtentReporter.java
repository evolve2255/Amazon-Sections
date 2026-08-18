package data;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public ExtentReports getRporterObject() {
	String filePath = 	System.getProperty("user.dir")+"\\reports\\Reports.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
	reporter.config().setReportName("Automation Results");
	reporter.config().setDocumentTitle("Into Amazon");
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tested BY", "Jishnu");
	return extent;
	
	}
}
