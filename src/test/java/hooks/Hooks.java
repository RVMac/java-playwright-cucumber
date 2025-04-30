package hooks;

import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.PlaywrightFactory;

import java.nio.file.Paths;

public class Hooks {

    @Before
    public void setUp() {
        String browserName = System.getProperty("browser", "chromium");
        PlaywrightFactory.initializeBrowser(browserName);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = PlaywrightFactory.getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/screenshots/" + scenario.getName() + ".png")));
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        PlaywrightFactory.closeBrowser();
    }
}
