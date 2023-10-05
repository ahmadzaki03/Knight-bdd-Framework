package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;

import utility.SeleniumUtility;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class CommonSteps extends SeleniumUtility {
    @Given("Open browser and navigate")
    public void openBrowserAndNavigate() {
        openBrowser();
    }

    private void openBrowser() {
    }

    @Then("Validate application title should be {string}")
    public void validateApplicationTitle(String expectedAppTitle) {
        //To Validate we can use JUnit Assert Class org.junit.Assert,
        String actualAppTitle = getDriver().getTitle();

        Assert.assertEquals("Application Title Validation",
                expectedAppTitle,
                actualAppTitle);
    }

    private WebDriver getDriver() {
        return null;
    }

    @Then("Close browser")
    public void closeBrowser() {
        driverQuit();
    }

    private void driverQuit() {
    }

    @Then("Validate the header title is {string}")
    public void validateHeaderTitle(String expectedHeaderTitle) {
        String actualHeaderTitle = getElementText(CommonPage.pageTitle);
        Assert.assertEquals("Validate Header Title" ,
                expectedHeaderTitle,
                actualHeaderTitle);
    }

    @When("Wait {int} Second")
    public void waitInSeconds(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e) {
            Assert.fail("Interrupted Exception happened on Wait Step");
        }
    }

    @When("Click on {string} Link")
    public void clickOnLink(String linkTexts) {
        By locator = CommonPage.getLinkLocator(linkTexts);
        clickOnElement(locator);
    }
}
