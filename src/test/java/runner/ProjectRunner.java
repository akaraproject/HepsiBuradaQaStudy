package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt"},
        features = "src/test/java/features",
        glue ={"steps","hooks"} , dryRun = false
,tags="@UI and @Senaryo2")



public class ProjectRunner {

}
