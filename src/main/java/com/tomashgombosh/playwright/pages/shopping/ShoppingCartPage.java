package com.tomashgombosh.playwright.pages.shopping;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;

import com.tomashgombosh.playwright.components.Header;
import com.tomashgombosh.playwright.components.shopping.Cart;
import com.tomashgombosh.playwright.constants.Routes;
import com.tomashgombosh.playwright.pages.AbstractAppPage;

@Getter
public class ShoppingCartPage extends AbstractAppPage {
    @Getter(AccessLevel.NONE)
    private final Page page;
    private final Header header;
    private final Cart cart;

    public ShoppingCartPage(final Page page) {
        this.page = page;
        this.header = new Header(page);
        this.cart = new Cart(page);
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
