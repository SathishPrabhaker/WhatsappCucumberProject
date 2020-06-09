package com.base;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class BaseClass {
	public static WebDriver driver;

	public WebDriver launchBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\new\\eclipse-workspace\\ContusCucum\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public void loadUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newWindow() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_T);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_T);
			switchToWindow(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void switchToWindow(int win) {
		try {
			Thread.sleep(2000);
			List<String> window = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(window.get(win));
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void buttonClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String generateRandomDate() {
		return new SimpleDateFormat("EEE_MMM_dd_yyyy_hhmmss").format(new Date());
	}
	public void screensShot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		File destination= new File("C:\\Users\\new\\eclipse-workspace\\ContusCucum\\ss\\"+generateRandomDate()+".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void quitBrowser() {
		try {
			Thread.sleep(2000);
			driver.quit();
		} catch(Exception e) {
			e.printStackTrace();
		}
}
}
