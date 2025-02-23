package com.tomashgombosh.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.tomashgombosh.playwright.pages.MainPage;
import com.tomashgombosh.playwright.pages.SearchPage;
import com.tomashgombosh.playwright.services.playwright.BrowserFactory;
import com.tomashgombosh.playwright.services.playwright.PlaywrightFactory;
import org.assertj.core.api.WithAssertions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static java.util.Objects.nonNull;

public class Setup implements WithAssertions {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected MainPage mainPage;
    protected SearchPage searchPage;

    @BeforeSuite
    public void setupPlaywright() {
        playwright = new PlaywrightFactory().create();
    }

    @BeforeClass
    public void initBrowserAndPage() {
        browser = new BrowserFactory().create();
        page = browser.newPage();
        mainPage = new MainPage(page);
        searchPage = new SearchPage(page);
    }

    @AfterClass
    public void closePageAndBrowser() {
        if (nonNull(page)) {
            page.close();
        }
        if (nonNull(browser)) {
            browser.close();
        }
    }

    @AfterSuite
    public void tearDown() {
        if (nonNull(playwright)) {
            playwright.close();
        }
    }
}
