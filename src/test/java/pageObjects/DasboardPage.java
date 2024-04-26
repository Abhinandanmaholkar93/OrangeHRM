package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericUtils;

public class DasboardPage {
    WebDriver driver;
    GenericUtils genericUtils;

    public DasboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.genericUtils = new GenericUtils(driver);
    }

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement dashText;

    @FindBy(xpath = "//nav[@class='oxd-navbar-nav']")
    WebElement navBar;

    @FindBy(xpath = "//span[text()='PIM']")
    WebElement PIM;

    @FindBy(xpath = "//a[text()='Add Employee']")
    WebElement addEmp;

    @FindBy(xpath = "//input[contains(@class,' orangehrm-firstname')]")
    WebElement enterFirstName;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement enterLastName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitCTA;

    public String dasText()
    {
        genericUtils.waitUntilElementVisibility(dashText);
       return dashText.getText();
    }

    public void navPresent()
    {
        genericUtils.waitUntilElementVisibility(dashText);
        System.out.println(navBar.isDisplayed());
    }
public void clickOnPIM()
{
    genericUtils.waitUntilElementVisibility(navBar);
    PIM.click();
}

public void clickOnAddEmp(String first,String lastName) throws InterruptedException {
    genericUtils.waitUntilElementVisibility(addEmp);
    genericUtils.clickWebElement(addEmp);
    Thread.sleep(2000);
    genericUtils.waitUntilElementVisibility(enterFirstName);
    enterFirstName.sendKeys(first);
    enterLastName.sendKeys(lastName);
    genericUtils.waitUntilElementVisibility(submitCTA);
    genericUtils.clickWebElement(submitCTA);
}
}
