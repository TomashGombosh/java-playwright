package com.tomashgombosh.playwright.services.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import com.tomashgombosh.playwright.Factory;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Accessors(fluent = true)
public class BrowserFactory implements Factory<Browser, BrowserFactory> {

    private Playwright playwright;

    @Override
    public Browser create() {
        final var browserFromEnv = System.getProperty("browser");
        return switch (Browsers.fromString(browserFromEnv)) {
            case CHROMIUM -> playwright.chromium().launch();
            case FIREFOX -> playwright.firefox().launch();
            case WEBKIT -> playwright.webkit().launch();
        };
    }
}
