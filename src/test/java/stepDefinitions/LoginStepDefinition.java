package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginPage;
import utils.TestContextSetUp;

import java.io.IOException;

public class LoginStepDefinition {

    TestContextSetUp testContextSetUp;
    LoginPage loginPage;

    public LoginStepDefinition(TestContextSetUp testContextSetUp) {
        this.testContextSetUp = testContextSetUp;
        this.loginPage = testContextSetUp.pageObjectManager.getLoginPage();
    }

    @Given("user should be on login page")
    public void user_should_be_on_login_page() throws IOException {
        testContextSetUp.testBase.WebDriverManager();
    }

    @Then("login page title should be matched with {string}")
    public void login_page_title_should_be_matched_with(String expTitle) {
        String actTitle = loginPage.loginPageTitle();
        Assert.assertEquals(actTitle, expTitle);
    }

    @Then("verify the branding logo")
    public void verify_the_branding_logo() throws InterruptedException {
        loginPage.verifyLogo();
    }

    @When("user enters username {string} and password {string}")
    public void enter_credential(String username, String password) throws InterruptedException {
        Thread.sleep(3000);
        loginPage.successfulLogin(username, password);
    }
}
