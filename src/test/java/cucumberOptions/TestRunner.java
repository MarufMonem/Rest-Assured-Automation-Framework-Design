package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/placeValidation.feature",
        plugin="json:target/jsonReports/cucumber-report.json",
        glue = "stepDefinitions",
        tags = "@AddPlace"
)
public class TestRunner {
}
