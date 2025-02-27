 package com.vittech.Automation.Base;

import org.openqa.selenium. chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

	
	public static ChromeDriver driver;
	@BeforeTest
	public void setup() {
	driver = new ChromeDriver();
	driver.get ("https://demo.guru99.com/V1/index.php");
	driver.manage().window().maximize();
	}
	@AfterTest
	public void teardown () {
	driver. quit();
	}
}
