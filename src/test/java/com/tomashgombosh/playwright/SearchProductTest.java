package com.tomashgombosh.playwright;

import org.assertj.core.api.Condition;

import com.tomashgombosh.playwright.model.Product;
import org.testng.annotations.Test;

public class SearchProductTest extends BaseTest {
    private static final String PRODUCT_NAME = "Laptop";

    @Test(description = "Search and Product Cart", groups = {"search", "all"})
    public void searchProduct() {
        final var condition = new Condition<Product>(product -> product.name().contains(PRODUCT_NAME),
                "Product name contains " + PRODUCT_NAME);
        mainPage.open();
        mainPage.waitForLoad();

        mainPage.searchForProduct(PRODUCT_NAME);

        searchPage.waitForLoad();
        searchPage.waitForNonEmptySearchResult();

        assertThat(searchPage.getSearchResult().getProducts())
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("root", "addToCartButton")
                .areExactly(1, condition);
    }
}
