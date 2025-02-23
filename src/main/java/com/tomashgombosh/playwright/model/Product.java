package com.tomashgombosh.playwright.model;

import java.util.regex.Pattern;

import com.microsoft.playwright.Locator;
import lombok.Builder;

@Builder
public record Product (
        Locator root,
        String name,
        String rating,
        double price,
        Locator addToCartButton
) {
    private static final String PRODUCT_NAME_LOCATOR = "[class*=product-title]";
    private static final String PRODUCT_RATING_LOCATOR = "[class*=rating]";
    private static final String PRODUCT_PRICE_LOCATOR = "[class*=price]";
    private static final Pattern RATING_PATTER = Pattern.compile("\\d+[%]");

    public Product(final Locator root) {
        this (
                root,
                root.locator(PRODUCT_NAME_LOCATOR).innerText(),
                RATING_PATTER.matcher(root.locator(PRODUCT_RATING_LOCATOR).getAttribute("style")).group(),
                Double.parseDouble(root.locator(PRODUCT_PRICE_LOCATOR).innerText()),
                root.locator("[type=button]")
        );
    }
}
