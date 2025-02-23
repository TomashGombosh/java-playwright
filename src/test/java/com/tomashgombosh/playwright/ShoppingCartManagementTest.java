package com.tomashgombosh.playwright;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import com.tomashgombosh.playwright.model.CartItem;
import net.datafaker.Faker;

import com.tomashgombosh.playwright.model.Product;
import org.testng.annotations.Test;

public class ShoppingCartManagementTest extends BaseTest {
    private static final Faker FAKER = new Faker();
    private static final int MAX_QUANTITY = 12;
    private static final int MIN_QUANTITY = 2;
    private static final String PRODUCT_NAME = "Music";

    @Test(description = "Shopping Cart Management", groups = {"cart", "all"})
    public void shoppingCartManagement() {
        mainPage.open();
        mainPage.waitForLoad();

        mainPage.searchForProduct(PRODUCT_NAME);

        searchPage.waitForLoad();
        searchPage.waitForNonEmptySearchResult();

        final var products = searchPage.getSearchResult().getProducts();
        final var defaultPrice = products.stream().map(Product::price).mapToDouble(Double::doubleValue).sum();
        products.forEach(product -> {
            product.addToCartButton().click();
            searchPage.getNotificationBar().getContainer().waitFor();
            searchPage.getNotificationBar().getCloseNotificationButton().click();
        });

        searchPage.getHeader().getShoppingCart().click();
        shoppingCartPage.waitForLoad();

        final var shoppingCartPrice = Double.parseDouble(shoppingCartPage.getShoppingCart().getTotalPrice().innerText());
        assertThat(defaultPrice)
                .as("Default total price is not correct")
                .isEqualTo(shoppingCartPrice);

        final var cartItems = shoppingCartPage.getShoppingCart().getCartItems();

        final var newTotalPrice = IntStream.of(0, cartItems.size() - 1)
                .mapToObj(i -> {
                    final var newQuantity = getNewQuantity();
                    shoppingCartPage.getShoppingCart().getCartItems().get(i).quantityInput().fill(String.valueOf(newQuantity));
                    return Map.of(i, newQuantity);
                })
                .map(priceCartItemMap -> this.getNewPrice(priceCartItemMap, cartItems))
                .mapToDouble(Double::doubleValue)
                .sum();

        shoppingCartPage.getShoppingCart().getUpdateCartButton().click();

        final var newShoppingCartPrice = Double.parseDouble(shoppingCartPage.getShoppingCart().getTotalPrice().innerText());

        assertThat(newTotalPrice)
                .as("Total price is not correct")
                .isEqualTo(newShoppingCartPrice);
    }

    private double getNewPrice(final Map<Integer, Integer> priceCartItemMap, final List<CartItem> cartItems) {
        final var index = priceCartItemMap.keySet().iterator().next();
        final var quantity = priceCartItemMap.get(index);
        final var item = cartItems.get(index);
        return item.price() * quantity;
    }

    private int getNewQuantity() {
        return FAKER.number().numberBetween(MIN_QUANTITY, MAX_QUANTITY);
    }
}
