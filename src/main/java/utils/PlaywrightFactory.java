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

    public static void initializeBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
//                                                    .setHeadless(true)
//                                                    .setSlowMo(100)
                                                );
        context = browser.newContext();
        page = context.newPage();
    }

    public static void closeBrowser() {
        context.close();
        browser.close();
        playwright.close();
    }
}
