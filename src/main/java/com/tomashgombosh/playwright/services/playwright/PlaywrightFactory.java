package com.tomashgombosh.playwright.services.playwright;

import com.microsoft.playwright.Playwright;

import com.tomashgombosh.playwright.Factory;

public class PlaywrightFactory implements Factory<Playwright, PlaywrightFactory> {

    @Override
    public Playwright create() {
        return Playwright.create();
    }
}
