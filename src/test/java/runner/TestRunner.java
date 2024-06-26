package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions (features = "src/test/resources/features"
,glue= {"steps"}
, plugin= {"pretty", "html:target/thursday_13-June/cucumber-html-report.html"}
)
public class TestRunner  extends TestBase {

}
