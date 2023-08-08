package com.yhao;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.junit.AfterClass;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/features"},
    plugin = {
        "pretty",
        "html:target/cucumber",
        "json:target/cucumberReportJsonFiles/cucumber-report.json"
    }
)
public class CucumberRunner {

  @AfterClass
  public static void generateReport(){
    PrettyCucumberReport prettyCucumberReport = new PrettyCucumberReport();
    prettyCucumberReport.generateCucumberReport();
  }
}
