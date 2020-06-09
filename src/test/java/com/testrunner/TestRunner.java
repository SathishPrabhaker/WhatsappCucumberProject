package com.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.JVMReport;

import cucumber.api.junit.Cucumber;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources" }, glue = {"com\\stepdefinition" }, monochrome = true, 
       plugin = {"json:src\\test\\resources\\Reporting\\Cucumber.json" })

public class TestRunner {
	@AfterClass
	public static void afterClass() {
		JVMReport.generateJVMReport(System.getProperty("user.dir") + "\\src\\test\\resources\\Reporting\\Cucumber.json");
	}
}
