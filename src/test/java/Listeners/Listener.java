package Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;
import resources.ExtentReport;

public class Listener extends Base implements ITestListener {

    WebDriver driver = null;
    ExtentTest test;
    ExtentReports reports = ExtentReport.getExtentReport();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // Thread safe in parallel execution

    @Override
    public void onTestStart(ITestResult result) {
        test = reports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
        System.out.println("Method :- "+ result.getMethod()+ " \n Class :- "+ result.getTestClass()+ " \n TestName :- "+ result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().fail(result.getThrowable());
        System.out.println("Inside onTestFailure() Method :: ");
        String methodName = result.getMethod().getMethodName();

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
            extentTest.get().addScreenCaptureFromPath(takeScreenShotAs(methodName, driver), result.getMethod().getMethodName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }
}
