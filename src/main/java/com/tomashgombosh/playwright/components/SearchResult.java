package com.tomashgombosh.playwright.components;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.tomashgombosh.playwright.model.Product;
import lombok.AccessLevel;
import lombok.Getter;

@Getter
public class SearchResult {
    @Getter(AccessLevel.NONE)
    private final Page page;
    private final Locator container;
    private final Locator title;
    private final Locator resultsContainer;
    private final List<Locator> products;

    public SearchResult(final Page page) {
        this.page = page;
        this.container = page.locator("[class*=search-page]");
        this.title = container.locator("h1");
        this.resultsContainer = container.locator("[class*=search-results]");
        this.products = this.resultsContainer.locator("[class*=item-box]").all();
    }

    public List<Product> getProducts() {
        return this.products
                .stream()
                .parallel()
                .map(Product::new)
                .toList();
    }
}
