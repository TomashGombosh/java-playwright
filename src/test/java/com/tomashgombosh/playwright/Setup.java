package com.tomashgombosh.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.assertj.core.api.WithAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.tomashgombosh.playwright.pages.main.MainPage;
import com.tomashgombosh.playwright.pages.search.SearchPage;
import com.tomashgombosh.playwright.pages.shopping.ShoppingCartPage;
import com.tomashgombosh.playwright.services.playwright.BrowserFactory;
import com.tomashgombosh.playwright.services.playwright.PlaywrightFactory;

import static java.util.Objects.nonNull;

public class Setup implements WithAssertions {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected MainPage mainPage;
    protected SearchPage searchPage;
    protected ShoppingCartPage shoppingCartPage;

    @BeforeTest(alwaysRun = true)
    public void initBrowserAndPage() {
        playwright = new PlaywrightFactory().create();
        browser = new BrowserFactory()
                .playwright(playwright)
                .create();

    }

    @BeforeMethod(alwaysRun = true)
    public void initPage() {
        page = browser.newPage();
        mainPage = new MainPage(page);
        searchPage = new SearchPage(page);
        shoppingCartPage = new ShoppingCartPage(page);
    }

    @AfterMethod(alwaysRun = true)
    public void closePage() {
        if (nonNull(page)) {
            page.close();
        }
    }

    @AfterTest(alwaysRun = true)
    public void closePageAndBrowser() {
        if (nonNull(browser)) {
            browser.close();
        }
        if (nonNull(playwright)) {
            playwright.close();
        }
    }
}
