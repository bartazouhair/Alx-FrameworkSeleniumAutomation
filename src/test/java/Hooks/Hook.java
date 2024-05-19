package Hooks;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ExtentHTMLReport;

public class Hook {
    private static ExtentHTMLReport extentReport = new ExtentHTMLReport();

    @Before
    public void beforeScenario(Scenario scenario) {
        extentReport.generateReport();
        extentReport.startTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            extentReport.logStep("Scenario failed: " + scenario.getName());
        } else {
            extentReport.logStep("Scenario passed: " + scenario.getName());
        }
        extentReport.flushReport();
    }

    public static ExtentHTMLReport getExtentReport() {
        return extentReport;
    }
}