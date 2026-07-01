package com.github.switcherapi.examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.github.switcherapi.PlaygroundFeatures.*;

/**
 * This example uses ${@link com.github.switcherapi.PlaygroundFeatures} class,
 * which inherits from ${@link com.switcherapi.client.SwitcherContext}.
 * <p>
 * When we use SwitcherContext, all SDK settings are automatically loaded from switcherapi.properties file.
 * This option is perfect for clean code and fast development without introducing extra code.
 */
public class AppPlayground {

	private static final Logger logger = LogManager.getLogger(AppPlayground.class);

	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	static void main() {
		runCalls();
		runScheduledCalls();
	}

	/**
	 * Simple example showing scheduled calls to Switcher with Strategy.
	 */
	private static void runScheduledCalls() {
		var switcher = getSwitcher(MY_SWITCHER).checkValue("user_1");

		scheduler.scheduleAtFixedRate(() -> {
			try {
				var time = System.currentTimeMillis();
				logger.info("Switcher is on: {} - {} ms", switcher.isItOn(), System.currentTimeMillis() - time);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}, 0, 500, TimeUnit.MILLISECONDS);
	}

	/**
	 * Simple example of how Switcher with Strategy works.
	 */
	private static void runCalls() {
		var switcher = getSwitcher(MY_SWITCHER);

		logger.info("Switcher {} is {} for user_1", MY_SWITCHER, switcher.checkValue("user_1").isItOn());
		logger.info("Switcher {} is {} for user_0", MY_SWITCHER, switcher.checkValue("user_0").isItOn());
		logger.info("Switcher {} is {} without params", MY_SWITCHER, switcher.resetInputs().isItOn());
	}
	
	public boolean myFeature() {
		return getSwitcher(MY_SWITCHER).isItOn();
	}

	public String concatString(String value1, String value2) {
		if (getSwitcher(MY_SWITCHER).isItOn()) {
			return value1 + " - " + value2;
		}

		return String.format("%s - %s", value1, value2);
	}

}
