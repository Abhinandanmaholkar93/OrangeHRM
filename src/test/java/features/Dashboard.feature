Feature: Dashboard page functionality

  Background:
    Given user should be on login page
    When user enters username "Admin" and password "admin123"

@VerifyDashboardPage
    Scenario: Verify dashboard title
       When user re-directs to the dashboard page title "Dashboard" should be present

  @VerifyNavBar
  Scenario: Verify navigation side bar and PIM Page
    When user clicks on the PIM, PIM page should be displayed
    Then clicks on the add employee CTA and enter first name "Abhinandan" and last name "Maholkar"





