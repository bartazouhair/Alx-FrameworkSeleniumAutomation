package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentHTMLReport {
	private ExtentReports extent;
	private ExtentTest test;

	public void generateReport() {
		try {
			// Utilisation d'un chemin relatif pour le rapport
			String path = System.getProperty("user.dir") + "/reports/index.html";

			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Alx Automation Results");
			reporter.config().setDocumentTitle("Test Alx");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Zouhair BARTA");
			System.out.println("Extent report initialized at: " + path);
		} catch (Exception e) {
			e.printStackTrace(); // Affichez la pile d'erreurs complète
			System.out.println("Error initializing Extent report: " + e.getMessage());
		}
	}

	public void startTest(String testName) {
		if (extent != null) {
			test = extent.createTest(testName);
		} else {
			System.out.println("Extent report is not initialized.");
		}
	}

	public void logStep(String stepDetails) {
		if (test != null) {
			test.info(stepDetails);
		} else {
			System.out.println("Test is not initialized: " + stepDetails);
		}
	}

	public void flushReport() {
		if (extent != null) {
			extent.flush();
			System.out.println("Extent report flushed and saved.");
		} else {
			System.out.println("Extent report is not initialized.");
		}
	}
}