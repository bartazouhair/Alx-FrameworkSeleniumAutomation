package modules;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true, plugin = { "pretty", "json:target/json/results.json" },
// features = {"src/test/java/features"},
// features = { "src/test/java/features/LoginApp.feature" },
//features = { "src/test/java/features/MyPlanningAlx.feature" },
//features = { "src/test/java/features/MyProfilAlx.feature" },
		features = { "src/test/java/features/MyCurriculums.feature" }, glue = { "modules",
				"stepsDefinitions" }, tags = "@run")

public class TestRunner {

}