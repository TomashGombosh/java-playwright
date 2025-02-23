package com.tomashgombosh.playwright.constants;

import static java.lang.String.format;

public final class Routes {
    public static final String BASE_URL = System.getProperty("app.url");
    public static final String MAIN = format("%s/", BASE_URL);
    public static final String SEARCH = format("%s/search", BASE_URL);
    public static final String CART = format("%s/cart", BASE_URL);
}
