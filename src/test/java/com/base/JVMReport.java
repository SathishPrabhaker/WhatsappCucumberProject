package com.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;





public class JVMReport {
	public static void generateJVMReport(String jsonFile) {
		File location = new File (System.getProperty("user.dir") + "\\src\\test\\resources\\Reporting");
		Configuration con = new Configuration(location, "Whatsapp Web");
		con.addClassifications("Operating System", "Windows 7");
		con.addClassifications("Browser", "Google Chrome");
		con.addClassifications("Version", "80");
		con.addClassifications("Project", "Whatsapp");
		
		List<String> jsonFiles= new ArrayList<String>();
		jsonFiles.add(jsonFile);
		
		ReportBuilder builder = new ReportBuilder(jsonFiles,con);
		builder.generateReports();
	}
}
