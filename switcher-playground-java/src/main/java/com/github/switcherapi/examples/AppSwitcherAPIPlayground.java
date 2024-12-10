package com.github.switcherapi.examples;

import com.github.switcherapi.client.SwitcherContextBase;
import com.github.switcherapi.client.SwitcherKey;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This code snippet is an all-in-one example of how to use the Switcher API.
 */
public class AppSwitcherAPIPlayground extends SwitcherContextBase {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @SwitcherKey
    public static final String MY_SWITCHER = "MY_SWITCHER";

    @Override
    protected void configureClient() {
        configureClient("switcherapi");
    }

    public static void main(String[] args) {
        new AppSwitcherAPIPlayground().configureClient();
        var switcher = getSwitcher(MY_SWITCHER);

        checkSwitchers();

        scheduler.scheduleAtFixedRate(switcher::isItOn, 0, 10, TimeUnit.SECONDS);
    }
}
