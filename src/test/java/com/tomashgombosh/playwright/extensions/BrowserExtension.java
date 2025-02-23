package com.tomashgombosh.playwright.extensions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import com.tomashgombosh.playwright.extensions.enums.Browsers;
import lombok.Getter;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static java.util.Objects.nonNull;

@Getter
public class BrowserExtension implements BeforeAllCallback, AfterAllCallback {

    private Browser browser;
    private Playwright playwright;

    @Override
    public void beforeAll(final ExtensionContext context) {
        playwright = Playwright.create();
        final var browserFromEnv = System.getProperty("browser");
        switch (Browsers.fromString(browserFromEnv)) {
            case CHROMIUM:
                this.setBrowser(playwright.chromium().launch());
                break;
            case FIREFOX:
                this.setBrowser(playwright.firefox().launch());
                break;
            case WEBKIT:
                this.setBrowser(playwright.webkit().launch());
                break;
        }
    }

    @Override
    public void afterAll(final ExtensionContext context) {
        if (nonNull(playwright)) {
            playwright.close();
        }
    }

    private void setBrowser(final Browser browser) {
        this.browser = browser;
    }
}
