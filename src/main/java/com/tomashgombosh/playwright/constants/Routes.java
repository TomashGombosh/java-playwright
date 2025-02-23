package com.tomashgombosh.playwright.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.lang.String.format;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Routes {
    public static final String BASE_URL = System.getProperty("app.url");
    public static final String MAIN = format("%s/", BASE_URL);
    public static final String SEARCH = format("%s/search", BASE_URL);
    public static final String CART = format("%s/cart", BASE_URL);
}
