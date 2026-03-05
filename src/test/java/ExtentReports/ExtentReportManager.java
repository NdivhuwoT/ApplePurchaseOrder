package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {

    private static String reportDir = System.getProperty("user.dir") + "/target/reports/ApplePurchaseOrderReport.html";

    private static ExtentReports extentReports;
    private static ExtentSparkReporter extentSparkReporter;

    public static ExtentReports extentReports() {
        extentReports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(new File(reportDir));
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setDocumentTitle("Apple Purchase Order Report");
        extentSparkReporter.config().setReportName("Apple Purchase Order Test Report");

        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Execution Machine", System.getProperty("machine.name"));

        return extentReports;
    }

}
