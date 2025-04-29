package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPage {
    private final Page page;
    private final Locator grandTotalElement;

    public CartPage(Page page){
        this.page = page;
        grandTotalElement = page.locator("//tfoot//strong");
    }

    public void CheckPriceValue(String itemName, String amountPerItem) {
        Locator priceElement = page.locator("//td[.=' "+ itemName +"']//following-sibling::td[1]");
        String actualPriceValue = priceElement.textContent().replace("$", "");
        assertEquals(amountPerItem, actualPriceValue);
    }

    public void CheckSubTotalValue(String itemName, String amountPerItem) {
        double unitAmount = Double.parseDouble(amountPerItem);

        Locator quantityInputBox = page.locator("//td[.=' " + itemName + "']//following-sibling::td[2]//input");
        double quantityInputBoxValue = Double.parseDouble(quantityInputBox.getAttribute("value"));

        double expectedSubtotal = unitAmount * quantityInputBoxValue;

        Locator subTotalElement = page.locator("//td[.=' " + itemName + "']//following-sibling::td[3]");
        double actualSubtotalValue = Double.parseDouble(subTotalElement.textContent().replace("$", ""));

        boolean areValuesSame = expectedSubtotal == actualSubtotalValue;
        assertTrue(areValuesSame);
    }

    public void verifyGrandTotalValue(String grandTotal) {
        String actualGrandTotalText = grandTotalElement.textContent();
        actualGrandTotalText = "$" + actualGrandTotalText.substring(7);
        Assert.assertEquals(grandTotal, actualGrandTotalText);
    }
}
