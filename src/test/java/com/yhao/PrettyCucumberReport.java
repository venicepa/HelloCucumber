package com.yhao;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PrettyCucumberReport {
  public void generateCucumberReport(){
    File reportOutputDirectory = new File("target");
    List<String> jsonFiles = new ArrayList<>();
    jsonFiles.add("target/cucumberReportJsonFiles/cucumber-report.json");

    String buildNumber="1";
    String projectName="cucumberProject";
    boolean runWithJenkins = false;
    boolean parallelTesting = false;

    Configuration configuration = new Configuration(reportOutputDirectory,projectName);

    // optional configuration
    configuration.setParallelTesting(parallelTesting);
    configuration.setRunWithJenkins(runWithJenkins);
    configuration.setBuildNumber(buildNumber);
    // optionally add metadata on main page
    configuration.addClassifications("Platform","Mac");
    configuration.addClassifications("Component","API Test");
    configuration.addClassifications("Version","1.0.0");

    ReportBuilder reportBuilder = new ReportBuilder(jsonFiles,configuration);
    Reportable reportable = reportBuilder.generateReports();
  }
}