package com.tomashgombosh.playwright.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;

@Getter
public class Header {
    @Getter(AccessLevel.NONE)
    private final Page page;
    private final Locator container;
    private final Locator shoppingCart;
    private final Locator searchInput;
    private final Locator searchButton;

    public Header(final Page page) {
        this.page = page;
        this.container = page.locator("[class*=header]");
        this.shoppingCart = container.locator("#topcartlink");
        this.searchInput = container.locator("#small-searchterms");
        this.searchButton = container.locator("[type=submit]");
    }

}
