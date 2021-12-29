package e2e.steps;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codeborne.selenide.WebDriverRunner;

import org.openqa.selenium.WebDriver;

import e2e.data.DataProvider;
import e2e.support.CucumberData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps {

    @Given("I am on the {string}")
    public void i_am_on_the(String url) {
        WebDriver driver = CucumberData.getDriver();
        WebDriverRunner.setWebDriver(driver);
        open(url);
    }

    @Given("{string} is set {string}")
    public void is_set(String key, String value) {
        DataProvider.set(key, value);
    }

    @When("I fill {string} with {string} value")
    public void i_fill_with_value(String target, String value) {
        CucumberData.getPage().find(target).sendKeys((String) DataProvider.get(value));
    }

    @When("I click the {string}")
    public void i_click_the(String target) {
        CucumberData.getPage().find(target).click();
    }

    @Then("{string} text contains {string}")
    public void text_is_value(String target, String expectedText) {
        String actualText = CucumberData.getPage().find(target).getText().toLowerCase();
        boolean result = actualText.contains(expectedText.toLowerCase());
        assertTrue(result);
    }

    @Given("I am on the randon page")
    public void i_am_on_the_randon_page() {
        String target = "randomPageLink";
        CucumberData.getPage().find(target).click();
    }

    @Then("{string} text is random")
    public void text_contains_random(String target) {
        String actualText = CucumberData.getPage().find(target).getText().toLowerCase();
        String notExpectedText = "Заглавная страница";
        boolean result = actualText.equals(notExpectedText.toLowerCase());
        assertFalse(result);
    }

}
