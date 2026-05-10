package com.github.switcherapi.examples;

import com.switcherapi.client.ContextBuilder;
import com.switcherapi.client.SwitcherContextBase;
import com.switcherapi.client.SwitcherKey;

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

    static void main() {
		configure(ContextBuilder.builder()
				.context(AppSwitcherAPIPlayground.class.getName())
				.local(true)
				.snapshotLocation("./src/main/resources/snapshots"));

		initializeClient();
		checkSwitchers();

        var switcher = getSwitcher(MY_SWITCHER);
        scheduler.scheduleAtFixedRate(switcher::isItOn, 0, 10, TimeUnit.SECONDS);
    }
}
