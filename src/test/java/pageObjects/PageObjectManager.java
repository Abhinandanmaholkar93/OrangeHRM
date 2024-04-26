package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public  WebDriver driver;
    LoginPage loginPage;
    DasboardPage dashboardPage;
    public PageObjectManager(WebDriver driver)
    {
        this.driver=driver;
    }

    public LoginPage getLoginPage()
    {
        this.loginPage=new LoginPage(driver);
        return loginPage;
    }

    public DasboardPage getDashboardPage()
    {
        this.dashboardPage=new DasboardPage(driver);
        return dashboardPage;
    }



}
