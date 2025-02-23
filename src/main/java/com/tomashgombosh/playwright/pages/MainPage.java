package com.tomashgombosh.playwright.pages;

import com.microsoft.playwright.Page;
import com.tomashgombosh.playwright.components.Header;
import com.tomashgombosh.playwright.constants.Routes;
import io.qameta.allure.Step;
import lombok.AccessLevel;
import lombok.Getter;

@Getter
public class MainPage extends AbstractAppPage {

    @Getter(AccessLevel.NONE)
    private final Page page;
    private final Header header;

    public MainPage(final Page page) {
        this.page = page;
        this.header = new Header(page);
    }

    @Override
    @Step("Open main page")
    public void open() {
        page.navigate(Routes.MAIN);
    }

    @Override
    @Step("Wait for main page load")
    public void waitForLoad() {
        page.waitForLoadState();
        this.header.getSearchInput().waitFor();
        this.header.getSearchButton().waitFor();
        this.header.getShoppingCart().waitFor();
    }

    @Step("Search for product: {productName}")
    public void searchForProduct(final String productName) {
        this.header.getSearchInput().fill(productName);
        this.header.getSearchButton().click();
    }
}
