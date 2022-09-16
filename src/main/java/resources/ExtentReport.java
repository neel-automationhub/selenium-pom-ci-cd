package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

    static ExtentReports reports;

    public static ExtentReports getExtentReport() {
        String path  = System.getProperty("user.dir")+"//reports//index.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setReportName("Web Automation Test");
        sparkReporter.config().setDocumentTitle("Automation Suite");

        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        reports.setSystemInfo("Reporting", "Patel");

        return reports;
    }

}