package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentHTMLReport {
    // ExtentReports instance to manage the report
    private ExtentReports extent;
    
    // ExtentTest instance to log test steps
    private ExtentTest test;

    // Method to generate the Extent report
    public void generateReport() {
        try {
            // Define the path for the report
            String path = System.getProperty("user.dir") + "/reports/index.html";

            // Configure the ExtentSparkReporter
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("Alx Automation Results");
            reporter.config().setDocumentTitle("Results Test Alx");
            reporter.config().setTheme(Theme.STANDARD);

            // Initialize ExtentReports and attach the reporter
            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Zouhair BARTA");
            System.out.println("Extent report initialized at: " + path);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error initializing Extent report: " + e.getMessage());
        }
    }

    // Method to start a new test in the report
    public void startTest(String testName) {
        if (extent != null) {
            test = extent.createTest(testName);
        } else {
            System.out.println("Extent report is not initialized.");
        }
    }

    // Method to log a step in the current test
    public void logStep(String stepDetails) {
        if (test != null) {
            test.info(stepDetails);
        } else {
            System.out.println("Test is not initialized: " + stepDetails);
        }
    }

    // Method to flush the Extent report and save it
    public void flushReport() {
        if (extent != null) {
            extent.flush();
            System.out.println("Extent report flushed and saved.");
        } else {
            System.out.println("Extent report is not initialized.");
        }
    }
}