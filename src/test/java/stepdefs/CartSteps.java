package stepdefs;

import com.microsoft.playwright.Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pages.CartPage;
import utils.PlaywrightFactory;

import java.util.List;
import java.util.Map;

public class CartSteps {
    Page page = PlaywrightFactory.getPage();
    CartPage cartPage = new CartPage(page);

    @Then("the price and subtotal value for each product is correct")
    public void thePriceAndSubtotalValueForEachProductIsCorrect(DataTable dataTable) {
        List<Map<String, String>> items = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> item : items) {
            String itemName = item.get("ItemName");
            String amountPerItem = item.get("AmountPerItem");

            cartPage.CheckPriceValue(itemName, amountPerItem);
            cartPage.CheckSubTotalValue(itemName, amountPerItem);
        }
    }

    @Then("the grand total value is equal to {string}")
    public void theGrandTotalValueIsEqualTo$(String grandTotal) {
        cartPage.verifyGrandTotalValue(grandTotal);
    }
}
