package runner;

import io.cucumber.testng.CucumberOptions;
import steps.ServiceNowBase;

@CucumberOptions(features="src/test/java/serviceNowfeatures", 
				glue="steps",
				monochrome = true, 
				publish = true)
				//tags = "@create")
public class ServiceNowRunner extends ServiceNowBase {

}
