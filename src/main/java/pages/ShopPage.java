package pages;

import com.microsoft.playwright.Page;

public class ShopPage {
    private Page page;

    public ShopPage(Page page){
        this.page = page;
    }

    public void BuyItem(String itemName, int count) {
        for (int i = 1; i <= count; i++){
            page.locator("//h4[.='"+ itemName +"']//following-sibling::p//a").click();
        }
    }
}
