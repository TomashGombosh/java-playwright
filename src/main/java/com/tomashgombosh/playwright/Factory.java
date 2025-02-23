package com.tomashgombosh.playwright;

public interface Factory<T, R extends Factory<T, R>> {
    T create();
}
