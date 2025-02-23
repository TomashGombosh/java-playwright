package com.tomashgombosh.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.tomashgombosh.playwright.extensions.BrowserExtension;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.RegisterExtension;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Setup implements WithAssertions {

    protected Browser browser;
    protected Page page;

    @RegisterExtension
    private static final BrowserExtension BROWSER_EXTENSION = new BrowserExtension();

    @BeforeAll
    void setup() {
        browser = BROWSER_EXTENSION.getBrowser();
    }

    @BeforeEach
    void startPage() {
        page = browser.newPage();
    }

    @AfterEach
    void closePage() {
        page.close();
    }

    @AfterAll
    void tearDown() {
        browser.close();
    }
}
