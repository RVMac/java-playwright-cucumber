package stepdefs;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;
import pages.GlobalPage;
import pages.HomePage;
import utils.PlaywrightFactory;

public class HomeSteps {
    Page page = PlaywrightFactory.getPage();
    HomePage homePage = new HomePage(page);
    GlobalPage globalPage = new GlobalPage(page);

    @Given("User navigates to Home Page")
    public void userNavigatesToHomePage() {
        homePage.navigateToPlaywrightHomePage();
    }

    @Given("I am in Home page")
    public void iAmInHomePage() {
        homePage.NavigateToHome();
    }

    @When("I navigate to Shop page")
    public void iNavigateToShopPage() {
        globalPage.clickShopNav();
    }

    @When("I navigate to Contact page")
    public void iNavigateToContactPage() {
        globalPage.clickContactNav();
    }

    @Then("User verifies the page title as {string}")
    public void userVerifiesThePageTitleAs(String expectedTitle) {
        homePage.checkTitleContains(expectedTitle);
    }
}
