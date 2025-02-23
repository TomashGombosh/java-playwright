package com.tomashgombosh.playwright.model;

import com.microsoft.playwright.Locator;
import lombok.Builder;

@Builder
public record Product(
        Locator root,
        String name,
        String rating,
        double price,
        Locator addToCartButton
) {
    private static final String PRODUCT_NAME_LOCATOR = "[class*=product-title] a";
    private static final String PRODUCT_RATING_LOCATOR = "[class=rating]";
    private static final String PRODUCT_PRICE_LOCATOR = "[class='price actual-price']";

    public static ProductBuilder withDefaults(final Locator root) {
        final var nameLocator = root.locator(PRODUCT_NAME_LOCATOR);
        final var ratingLocator = root.locator(PRODUCT_RATING_LOCATOR).locator("div");
        final var priceLocator = root.locator(PRODUCT_PRICE_LOCATOR);
        nameLocator.waitFor();
        return Product.builder().root(root)
                .name(nameLocator.textContent())
                .rating(ratingLocator.getAttribute("style").replaceAll("[a-z: ]", ""))
                .price(Double.parseDouble(priceLocator.textContent()))
                .addToCartButton(root.locator("[type=button]"));
    }
}
