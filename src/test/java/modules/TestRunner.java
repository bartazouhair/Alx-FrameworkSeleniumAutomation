package modules;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Indicate that the class should use the Cucumber class to run tests
@RunWith(Cucumber.class)

// Define Cucumber options for this test runner
@CucumberOptions(
		// Enforce strict mode which will fail the execution if there are undefined or
		// pending steps
		strict = true,

		// Specify the output plugins for the test results
		plugin = { "pretty", // Print the Gherkin source with additional colors and stack traces for errors
				"json:target/json/results.json" // Output test results in JSON format at the specified path
		},

		// Define the path to the feature files
		features = { "src/test/java/features" },

		// Specify the packages containing step definitions and hooks
		glue = { "modules", "stepsDefinitions", "Hooks" },

		// Tags to filter which tests to run
		tags = "@run")
public class TestRunner {
	// This class will be used as the entry point for running the Cucumber tests
	// with the specified options
}
