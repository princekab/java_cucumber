package cucumber_training;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty","jason:Target/"},
		features = {"src/Cucumber/"}
		)
public class RunnerClass {

}
