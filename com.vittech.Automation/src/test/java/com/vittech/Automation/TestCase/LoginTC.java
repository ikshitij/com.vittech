package com.vittech.Automation.TestCase;
import org.testng.Assert;
import com.vittech.Automation.Utiliy.*;
import org.testng.annotations.Test;
import com.vittech.Automation.Base.*;
import com.vittech.Automation.PageObject.*;



public class LoginTC extends TestBase {
	public static void main(String[] args){
	@Test 
	public void selectByDate() throws InterruptedException {
	Thread. sleep (3000);
	
	}
	
	@Test
	public void login() throws InterruptedException {
	LoginPage lp = new LoginPage(driver);
	lp. setUserID("mngr613119");
	lp.setPassword("gajagUs");
	lp.clickOnSubmitBtn();
	Thread.sleep(3000);
	Helper helper = new Helper(driver);
	helper.captureScreenshot("/Users/kshitijsalunkhe/eclipse-workspace/com.vittech.Automation/screenshot/image.png");
	Assert.assertEquals(driver.getTitle(), "GTPL Bank Manager HomePage");

}}
}
