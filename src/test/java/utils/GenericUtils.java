package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class GenericUtils {
    WebDriver driver;
    JavascriptExecutor js;
    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWebElement(WebElement click)
    {
        js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",click);
    }



    public void waitUntilElementVisibility(WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void SwitchWindowToChild()
    {
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1 =s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);
    }
    public void SwitchToParentWindow()
    {
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1 =s1.iterator();
        String parentWindow = i1.next();
        driver.switchTo().window(parentWindow);
    }
}









