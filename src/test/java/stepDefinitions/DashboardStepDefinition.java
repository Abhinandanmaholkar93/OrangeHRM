package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.DasboardPage;
import utils.TestContextSetUp;

import java.io.IOException;

public class DashboardStepDefinition {

    TestContextSetUp testContextSetUp;
    DasboardPage dashboardPage;

    public DashboardStepDefinition(TestContextSetUp testContextSetUp) {
        this.testContextSetUp = testContextSetUp;
        this.dashboardPage = testContextSetUp.pageObjectManager.getDashboardPage();
    }


    @When("user re-directs to the dashboard page title {string} should be present")
    public void dashboardTitle(String expDashText) {
        String actDashText = dashboardPage.dasText();
        System.out.println(actDashText);
        Assert.assertEquals(actDashText, expDashText);
    }

    @When("user clicks on the PIM, PIM page should be displayed")
    public void navClick() {
        dashboardPage.navPresent();
        dashboardPage.clickOnPIM();
    }

    @Then("clicks on the add employee CTA and enter first name {string} and last name {string}")
    public void employeeFirstName(String first, String lastName) throws InterruptedException {
        dashboardPage.clickOnAddEmp(first, lastName);

    }



}
