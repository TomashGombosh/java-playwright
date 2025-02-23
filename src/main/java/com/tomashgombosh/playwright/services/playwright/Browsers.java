package com.tomashgombosh.playwright.services.playwright;

public enum Browsers {
    CHROMIUM,
    FIREFOX,
    WEBKIT;

    public static Browsers fromString(final String browser) {
        return Browsers.valueOf(browser.toUpperCase());
    }
}
