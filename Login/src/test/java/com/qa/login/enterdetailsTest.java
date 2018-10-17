package com.qa.login;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class enterdetailsTest {
	
	public WebDriver driver = null;
	ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\loginReport.html", true);
	ExtentTest test;
	
	@Before 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		}
	
	@Test
	public void getSearched() throws InterruptedException {
		
		//creates a username and password
		test = extent.startTest("Login");
		driver.get("http://thedemosite.co.uk/savedata.php");
		
		test.log(LogStatus.INFO, "Demo site opened");
		createUser newUser = PageFactory.initElements(driver, createUser.class);
		newUser.createUser("craig", "1234");
		test.log(LogStatus.INFO, "username and password created");
		
		//enters the username and password and checks it logs in
		driver.get("http://thedemosite.co.uk/login.php");
		test.log(LogStatus.INFO,  "Login page reached");
		enterdetails enterDetails = PageFactory.initElements(driver, enterdetails.class);
		enterDetails.getSearched("craig", "1234");
		test.log(LogStatus.INFO, "Login successful");
		
		if (enterDetails.searchText().getText().equals("**Successful Login**")) {
			test.log(LogStatus.PASS, "Login successfull");
		} else {
			test.log(LogStatus.FAIL, "Login unsuccessful");
		}
		
		assertEquals("**Successful Login**", enterDetails.searchText().getText());
		Thread.sleep(1000);
	
	}
	@After
	public void teardown() {
		driver.quit();
		extent.flush();

		
	}
}
