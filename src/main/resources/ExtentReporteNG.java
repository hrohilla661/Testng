import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "//test-output//extentReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Niger Automation Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("harsh", "QA");
		
		return extent;
	}
}