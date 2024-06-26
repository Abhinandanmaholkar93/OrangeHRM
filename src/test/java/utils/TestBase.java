package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;
    public WebDriver WebDriverManager() throws IOException {
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//Global.properties");
        Properties pro=new Properties();
        pro.load(fis);
        String orangeUrl= pro.getProperty("url");
        String browser=pro.getProperty("browser");
        if(driver==null)
        {
            if(browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                //firefox code
                driver=new FirefoxDriver();
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.get(orangeUrl);

        }
        return driver;
    }
}
