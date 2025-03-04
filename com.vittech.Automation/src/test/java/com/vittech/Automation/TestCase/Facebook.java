package com.vittech.Automation.TestCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vittech.Automation.Utiliy.Helper;

public class Facebook {
   
        // Set path to chromedriver
       // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

    	
    	
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        @Test
        public void facebookAutomaton() throws InterruptedException {
        // Open a website
        driver.get("https://facebook.com");
        
       Thread.sleep(1000);
        // Locate the element (for example, a button with id='submitBtn')
        WebElement createNewAccount = driver.findElement(By.xpath("(//a[@role='button'])[2]"));

        // Click the button
        createNewAccount.click();

    	Helper helper = new Helper(driver);
        WebElement date = driver.findElement(By.xpath("//select[@name=\"birthday_day\"]"));


        Helper.handleselectropdown(date,15);
        
        
        
        WebElement month = driver.findElement(By.xpath("//select[@name=\"birthday_month\"]"));

        Helper.handleselectdropdown(month,"5");
        
        
        
        WebElement year = driver.findElement(By.xpath("//select[@name=\"birthday_year\"]"));
        
        Helper.handleselectdrapdown( "2021", year);

        
        List<WebElement> elements = driver.findElements(By.xpath("//select[@id='day']//option"));
        
        Helper.handleselectdropdown( "7", elements);

        
        
        
        
        
        
        
        
        
        
        
        
        // Quit the driver
        //driver.quit();
    }
}

