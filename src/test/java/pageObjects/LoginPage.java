package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericUtils;

public class LoginPage {
    WebDriver driver;
    GenericUtils genericUtils;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.genericUtils = new GenericUtils(driver);
    }
@FindBy(css = ".orangehrm-login-branding img")
    WebElement companyLogo;

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    public String loginPageTitle()
    {
        return driver.getTitle();
    }
    public void verifyLogo() throws InterruptedException {
        //genericUtils.waitUntilElementVisibility(companyLogo);
        Thread.sleep(3000);
        System.out.println(companyLogo.isDisplayed());
    }
     public void successfulLogin(String un,String pass) throws InterruptedException {
        //genericUtils.waitUntilElementVisibility(username);
         Thread.sleep(3000);
        username.sendKeys(un);
        genericUtils.waitUntilElementVisibility(password);
        password.sendKeys(pass);
        genericUtils.waitUntilElementVisibility(loginBtn);
        genericUtils.clickWebElement(loginBtn);
     }

}
