package com.tomashgombosh.playwright.components.search;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;

import com.tomashgombosh.playwright.model.Product;

@Getter
public class Result {
    @Getter(AccessLevel.NONE)
    private final Page page;
    private final Locator container;
    private final Locator title;
    private final Locator resultsContainer;
    private final Locator productsLocator;

    public Result(final Page page) {
        this.page = page;
        this.container = this.page.locator("[class*=search-page]");
        this.title = this.container.locator("h1");
        this.resultsContainer = this.container.locator("[class*=search-results]");
        this.productsLocator = this.resultsContainer.locator("[class*=item-box]");
    }

    public List<Locator> getProductLocators() {
        return this.productsLocator.all();
    }

    public List<Product> getProducts() {
        return this.getProductLocators()
                .stream()
                .parallel()
                .map(root -> Product.withDefaults(root).build())
                .toList();
    }
}
