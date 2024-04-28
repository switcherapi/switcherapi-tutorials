package com.github.switcherapi.examples;

import com.github.switcherapi.client.ContextBuilder;
import com.github.switcherapi.client.SwitcherContextBase;
import com.github.switcherapi.client.SwitcherKey;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This code snippet is an all-in-one example of how to use the Switcher API.
 */
public class AppSwitcherAPIPlayground extends SwitcherContextBase {

    @SwitcherKey
    public static final String MY_SWITCHER = "MY_SWITCHER";

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        configure(ContextBuilder.builder()
                .contextLocation(AppSwitcherAPIPlayground.class.getName())
                .url("https://api.switcherapi.com")
                .domain("Playground")
                .component("switcher-playground")
                .apiKey("JDJiJDA4JEFweTZjSTR2bE9pUjNJOUYvRy9raC4vRS80Q2tzUnk1d3o1aXFmS2o5eWJmVW11cjR0ODNT")
        );

        initializeClient();
        var switcher = getSwitcher(MY_SWITCHER);

        scheduler.scheduleAtFixedRate(() ->
                System.out.println("Boolean variation is " + switcher.isItOn()), 0, 10, TimeUnit.SECONDS);
    }
}
