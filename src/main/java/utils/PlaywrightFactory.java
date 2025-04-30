package utils;

import com.microsoft.playwright.*;

public class PlaywrightFactory {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static Page getPage() {
        return page;
    }

    public static void initializeBrowser(String browserName) {
        playwright = Playwright.create();

        boolean isHeadless = true;

        switch (browserName){
            case "firefox":
                browser = playwright.firefox().launch(
                        new BrowserType.LaunchOptions()
                                .setHeadless(isHeadless)
                                .setSlowMo(100)
                );
                break;
            case "edge":
                browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions()
                                .setHeadless(isHeadless)
                                .setSlowMo(100)
                                .setChannel("msedge")
                );
                break;
            case "chromium":
            default:
                browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions()
                                .setHeadless(isHeadless)
                                .setSlowMo(100)
                );

        }

        context = browser.newContext();
        page = context.newPage();
    }

    public static void closeBrowser() {
        context.close();
        browser.close();
        playwright.close();
    }
}
