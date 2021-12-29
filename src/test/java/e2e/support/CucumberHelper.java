package e2e.support;

import static com.codeborne.selenide.Selenide.screenshot;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import e2e.pages.PageProvider;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class CucumberHelper {

    private final static int TIMEOUT_SECONDS = 10;

    @Before
    public void tearUp(){
        CucumberData.setDriver(new ChromeDriver());
        CucumberData.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIMEOUT_SECONDS));
        CucumberData.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_SECONDS));
    }

    @After
    public void tearDown(){
        CucumberData.getDriver().quit();
    }

    @AfterStep
    public void url() {
        CucumberData.setProvider(new PageProvider());
        CucumberData.setPage(CucumberData.getProvider().find());
    }

    @AfterStep
    public void screen() {
        screenshot(String.valueOf(System.currentTimeMillis()));
    }
}
