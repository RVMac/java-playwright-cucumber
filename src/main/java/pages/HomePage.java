package pages;

import com.microsoft.playwright.Page;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {
    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void navigateToPlaywrightHomePage() {
        page.navigate("https://playwright.dev");
    }

    public void checkTitleContains(String title){
        assertThat(page).hasTitle(Pattern.compile("Playwright"));
    }

    public void NavigateToHome() {
        page.navigate("https://jupiter.cloud.planittesting.com/#/home");
    }
}
