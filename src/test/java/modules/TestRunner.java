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
//features = { "src/test/java/features/MyCurriculumAlx.feature" },
//features = { "src/test/java/features/MyProjectsAlx.feature" },
//features = { "src/test/java/features/SearchProjectAlx.feature" },
//features = { "src/test/java/features/SandboxesAlx.feature" },
		features = { "src/test/java/features/LoginApp.feature" }, glue = { "modules",
				"stepsDefinitions", "Hooks" }, tags = "@run")

public class TestRunner {

}