package com.qa.waits;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class WaitTest {
	
	public WebDriver driver = null;	
	ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\waitsReport.html", true);
	ExtentTest test;
	
	@Before 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		}

	@Test
	public void waitTest() {
		test = extent.startTest("search test");
		driver.get("https://chrisperrins95.github.io/AutomatedTestingExample/");
		test.log(LogStatus.INFO, "Page opened");
		
		test.log(LogStatus.INFO, "Timeout applied and result search begun");
		waits wait = PageFactory.initElements(driver, waits.class);
		
		
		if (wait.getElement(driver).getText().equals("I HATE YOU!")){
			test.log(LogStatus.PASS, "Test passed");
		} else {
			test.log(LogStatus.FAIL, "Test failed");
		}
		extent.endTest(test);
		assertEquals("I HATE YOU!", wait.getElement(driver).getText());
	}

		@After
		public void teardown() {
			extent.flush();
			driver.quit();
		}

}
