package com.tomashgombosh.playwright.pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import lombok.Getter;

import com.tomashgombosh.playwright.components.Header;
import com.tomashgombosh.playwright.components.NotificationBar;
import com.tomashgombosh.playwright.components.SearchResult;
import com.tomashgombosh.playwright.constants.Routes;

import static org.awaitility.Awaitility.await;

@Getter
public class SearchPage extends AbstractAppPage {
    private final Page page;
    private final Header header;
    private final NotificationBar notificationBar;
    private final SearchResult searchResult;

    public SearchPage(final Page page) {
        this.page = page;
        this.header = new Header(page);
        this.notificationBar = new NotificationBar(page);
        this.searchResult = new SearchResult(page);
    }

    @Override
    @Step("Open search page")
    public void open() {
        page.navigate(Routes.SEARCH);
    }

    @Override
    @Step("Wait for search page load")
    public void waitForLoad() {
        page.waitForLoadState();
        this.searchResult.getResultsContainer().waitFor();
    }

    @Step("Wait to search result shown results")
    public void waitForNonEmptySearchResult() {
        await()
                .until(() -> !this.searchResult.getProductLocators().isEmpty());
    }
}
