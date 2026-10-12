package com.pratik.ypassist.com.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.pratik.ypassist.basepage.DriverSetup;

public class ScreenshotUtil {

	private WebDriver driver;

	public ScreenshotUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void screenshotSuccessClass(String testName) {
		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destination = new File("screenshots/passed/" + testName + "_" + timestamp + ".png");

		// Rename and save
		if (source.renameTo(destination)) {
			System.out.println("Screenshot saved: " + destination.getAbsolutePath());
		} else {
			System.out.println("Failed to save screenshot.");
		}

	}

	public void screenshotFailureClass(String testName)  {

		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destination = new File("screenshots/failed/" + testName + "_" + timestamp + ".png");

		// Rename and save
		if (source.renameTo(destination)) {
			System.out.println("Screenshot saved: " + destination.getAbsolutePath());
		} else {
			System.out.println("Failed to save screenshot.");
		}

	}
}
