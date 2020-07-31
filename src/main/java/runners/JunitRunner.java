package runners;
        import org.junit.runner.RunWith;
        import cucumber.api.CucumberOptions;
        import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue= {"StepDef"},
        dryRun = false,
        monochrome = true,
        format = {"pretty", "html:TestReports", "json:TestReports/cucumber.json", "junit:TestReports/cucumber.xml"}

)
public class JunitRunner {
}