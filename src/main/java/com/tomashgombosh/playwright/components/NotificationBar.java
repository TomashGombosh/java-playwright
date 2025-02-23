package com.tomashgombosh.playwright.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;

@Getter
public class NotificationBar {
    @Getter(AccessLevel.NONE)
    private final Page page;
    private final Locator container;
    private final Locator closeNotificationButton;

    public NotificationBar(final Page page) {
        this.page = page;
        this.container = this.page.locator("#bar-notification");
        this.closeNotificationButton = this.container.locator(".close");
    }


}
