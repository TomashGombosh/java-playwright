package com.tomashgombosh.playwright.model;

import com.microsoft.playwright.Locator;

public record CartItem(
        Locator root,
        Locator removeCheckbox,
        String name,
        double price,
        Locator quantityInput,
        double totalPrice
) {

    public CartItem(final Locator root) {
        this(
                root,
                root.locator("[name=removefromcart]"),
                root.locator("[class*=product-name]").innerText(),
                Double.parseDouble(root.locator("[class*=product-unit-price]").textContent().replaceAll("[^\\d.]", "")),
                root.locator("[class*=qty-input]"),
                Double.parseDouble(root.locator("[class*=product-subtotal]").textContent().replaceAll("[^\\d.]", ""))
        );
    }
}
