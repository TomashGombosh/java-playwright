package com.tomashgombosh.playwright.pages;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;

import com.tomashgombosh.playwright.components.Header;
import com.tomashgombosh.playwright.components.ShoppingCart;
import com.tomashgombosh.playwright.constants.Routes;

@Getter
public class ShoppingCartPage extends AbstractAppPage {
    @Getter(AccessLevel.NONE)
    private final Page page;
    private final Header header;
    private final ShoppingCart shoppingCart;

    public ShoppingCartPage(final Page page) {
        this.page = page;
        this.header = new Header(page);
        this.shoppingCart = new ShoppingCart(page);
    }

    @Override
    public void open() {
        page.navigate(Routes.CART);
    }

    @Override
    public void waitForLoad() {
        page.waitForLoadState();
    }
}
