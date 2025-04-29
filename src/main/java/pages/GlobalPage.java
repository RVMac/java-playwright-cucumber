package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class GlobalPage {
    private Page page;

    private final Locator NavShop;
    private final Locator NavContact;
    private final Locator NavCart;

    public GlobalPage(Page page) {
        this.page = page;

        NavShop = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Shop").setExact(true));
        NavContact = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact"));
        NavCart = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart"));
    }

    public void clickShopNav() {
        NavShop.click();
    }

    public void clickCartNav() {
        NavCart.click();
    }

    public void clickContactNav() {
        NavContact.click();
    }
}
