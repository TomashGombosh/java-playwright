package com.tomashgombosh.playwright.components;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.tomashgombosh.playwright.model.CartItem;
import lombok.Getter;

@Getter
public class ShoppingCart {
    private final Page page;
    private final Locator container;
    private final Locator items;
    private final Locator updateCartButton;
    private final Locator totalPrice;

    public ShoppingCart(final Page page) {
        this.page = page;
        this.container = page.locator("form[action='/cart']");
        this.items = container.locator("[class='cart-item-row']");
        this.updateCartButton = container.locator("[name='updatecart']");
        this.totalPrice = container.locator("[class='product-price order-total']");
    }

    public List<Locator> getShoppingCartItems() {
        return this.items.all();
    }

    public List<CartItem> getCartItems() {
        return this.getShoppingCartItems()
                .stream()
                .parallel()
                .map(CartItem::new)
                .toList();
    }
}
