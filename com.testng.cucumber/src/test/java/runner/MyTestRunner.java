package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions( 
		tags = {"@DemoTest"},
glue = {"stepdefs"}, 
		plugin = {"html:target/cucumber-reports/Gokul_Report/cucumber-pretty","json:target/json-cucumber-reports/Gokul_Report/cukejson.json",
		"testng:target/testng-cucumber-reports/Gokul_Report/cuketestng.xml" }, 
		features = {"src/test/resources/features"})

public class MyTestRunner extends AbstractTestNGCucumberTests {
	
	private static long duration;

	@BeforeClass
	public static void before() {
		duration = System.currentTimeMillis();
		System.out.println("Scenario Execution started");
	}
	
	@AfterClass
	public static void after() {
		duration = System.currentTimeMillis() - duration;
		System.out.println("Execution DURATION in MilliSeconds - "+ duration);
	}
	

	

}
