package com.github.switcherapi.examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.github.switcherapi.PlaygroundFeatures.MY_SWITCHER;
import static com.switcherapi.client.SwitcherContext.getSwitcher;

/**
 * This example shows how to use the throttle feature.
 * <p>
 * Throttling is a feature that allows you to limit the number of times a switcher is fetched from a remote server.
 * This can dramatically improve performance for critical code paths.
 */
public class AppPlaygroundThrottle {

	private static final Logger logger = LogManager.getLogger(AppPlaygroundThrottle.class);

	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	static void main() {
		var feature = getSwitcher(MY_SWITCHER)
				.remote(true)
				.throttle(1000);

		var random = new Random();
		scheduler.scheduleAtFixedRate(() -> {
			var input = "user_1";
			if (random.nextInt() % 2 == 0) {
				input = "user_0";
			}

			var start = System.currentTimeMillis();
			var result = feature.checkValue(input).isItOn();
			logger.info("Switcher {} is {} for {} ({}ms)", MY_SWITCHER, result, input, System.currentTimeMillis() - start);
		}, 0, 1, TimeUnit.SECONDS);
	}

}
