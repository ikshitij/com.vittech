package com.vittech.Automation.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.vittech.Automation.Base.*;
import com.vittech.Automation.PageObject.*;



public class LoginTC extends TestBase {
	
	@Test (priority = 1)
	public void verifyLoginPageTitle() throws InterruptedException {
	Thread. sleep (3000);
	Assert.assertEquals(driver.getTitle(), "GTPL Bank Home Page");
	}
	
	@Test(priority = 2)
	public void login() throws InterruptedException {
	LoginPage lp = new LoginPage(driver);
	lp. setUserID("mngr613119");
	lp.setPassword("gajagUs");
	lp.clickOnSubmitBtn();
	Thread.sleep(3000);
	Assert.assertEquals(driver.getTitle(), "GTPL Bank Manager HomePage");

}
}
