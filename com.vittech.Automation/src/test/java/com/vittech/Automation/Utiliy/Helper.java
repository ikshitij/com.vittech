package com.vittech.Automation.Utiliy;



import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Helper {
    private WebDriver driver;

    // Constructor
    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    // Handle JavaScript alert
    public void handleAlert(boolean accept) {
        Alert alert = driver.switchTo().alert();
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }
    
    public static void handleselectropdown (WebElement ele, int index)
    {
    try {
    new Select(ele).selectByIndex(index);;
    } catch (Exception e) {
    e.printStackTrace();
    }
}
    
    
    
    
    public static void handleselectdropdown (WebElement ele, String value)
    {
    try {
    new Select(ele).selectByValue(value);
    } catch (Exception e) {
    e.printStackTrace();
    }
}
    
    
    public static void handleselectdrapdown (String visibleText, WebElement ele)
    {
    try {
    new Select(ele).selectByVisibleText(visibleText);
    } catch (Exception e) {
    e.printStackTrace();
    }
    }
    
    
    public static void handleselectdropdown(String value, List<WebElement> ele)
    {
    for(WebElement el:ele)
    {
    if(el.getText().equals(value))
    {
    el.click();
    break;
    }
    }
    }
    
    

    // Capture screenshot
    public void captureScreenshot(String filePath) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(source, new File(filePath));
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }

    // Handle multiple windows or tabs
    public void switchToWindow(String targetTitle) {
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(mainWindow); // switch back if target not found
    }

    // Switch to frame by index, name, or WebElement
    public void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }

    public void switchToFrame(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    // Switch to nested frame
    public void switchToNestedFrame(String parentFrame, String childFrame) {
        driver.switchTo().frame(parentFrame);
        driver.switchTo().frame(childFrame);
    }

    // Switch back to the default content (main page)
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // Handle select dropdown
    public void selectDropdownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectDropdownByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public void selectDropdownByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    // Handle bootstrap dropdown
    public void selectBootstrapDropdownOption(WebElement dropdown, String optionText) {
        dropdown.click();
        WebElement option = driver.findElement(By.xpath("//a[text()='" + optionText + "']"));
        option.click();
    }

    // Handle waits in selenium
    public WebElement waitForElementToBeVisible(By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Perform mouse hover
    public void mouseHover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
