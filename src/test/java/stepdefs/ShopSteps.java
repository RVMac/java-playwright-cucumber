package stepdefs;

import com.microsoft.playwright.Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.GlobalPage;
import pages.ShopPage;
import utils.PlaywrightFactory;

import java.util.List;
import java.util.Map;

public class ShopSteps {
    Page page = PlaywrightFactory.getPage();
    ShopPage shopPage = new ShopPage(page);
    GlobalPage globalPage = new GlobalPage(page);

    @When("I buy the following items:")
    public void iBuyTheFollowingItems(DataTable dataTable) {
        List<Map<String, String>> items = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> item : items) {
            String itemName = item.get("ItemName");
            int count = Integer.parseInt(item.get("Quantity"));
            shopPage.BuyItem(itemName, count);
        }
    }

    @When("I navigate to Cart page")
    public void iNavigateToCartPage() {
        globalPage.clickCartNav();
    }
}
