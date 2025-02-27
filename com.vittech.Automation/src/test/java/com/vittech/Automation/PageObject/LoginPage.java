package com.vittech.Automation.PageObject;
import org.openqa.selenium.WebDriver;
import org. openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	// Page objects : web element on the login page
	@FindBy(name = "uid")
	@CacheLookup
	WebElement userid_txt;
	
	@FindBy (name = "password")
	@CacheLookup
	WebElement password_txt;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement submitBtn;
	
	public LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	public void setUserID(String username) {
	try {
	userid_txt. clear();
	userid_txt. sendKeys(username);
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	
public void setPassword(String pass) {
try {
password_txt.clear();
password_txt.sendKeys(pass);
} catch (Exception e) {
e.printStackTrace();
}
}

public void clickOnSubmitBtn() {
try {
submitBtn.click();
} catch (Exception e) {
e.printStackTrace();
}
}
}
