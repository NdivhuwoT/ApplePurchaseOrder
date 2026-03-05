package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result){
        extentTest = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        extentTest.fail("Test Case "+ result.getMethod().getMethodName() + " Has failed");
    }

    @Override
    public void onTestSuccess(ITestResult result){
        extentTest.pass("Test Case "+ result.getMethod().getMethodName() + " Has Passed");
    }

    @Override
    public void onTestSkipped(ITestResult result){
        extentTest.skip("Test Case "+ result.getMethod().getMethodName() + " Has been Skipped");
    }

    @Override
    public void onFinish(ITestContext context){
        extent.flush();
    }

    @Override
    public void onStart(ITestContext context){
        extent = ExtentReportManager.extentReports();
    }

}
