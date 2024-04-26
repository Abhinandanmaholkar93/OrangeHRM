Feature: Login page functionality

  Background:
    Given user should be on login page

  @OrangeHRM_Title
  Scenario: verify the login page title
    Then login page title should be matched with "OrangeHRM"

    @VerifyCompanyBrandingLogo
    Scenario: Verify company branding logo
      Then verify the branding logo

      @verifySuccessfullyLogin
      Scenario: verify successfully login
        When user enters username "Admin" and password "admin123"

