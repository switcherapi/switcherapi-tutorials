package com.github.switcherapi.examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

	static void main() {
		final AppPlayground app = new AppPlayground();

		logger.info("Switcher {} is {} for user_1", MY_SWITCHER, app.myFeatureParams("user_1"));
		logger.info("Switcher {} is {} for user_0", MY_SWITCHER, app.myFeatureParams("user_0"));
		logger.info("Switcher {} is {} without params", MY_SWITCHER, app.myFeature());
	}
	
	public boolean myFeature() {
		return getSwitcher(MY_SWITCHER)
				.isItOn();
	}
	
	public boolean myFeatureParams(String value) {
		return getSwitcher(MY_SWITCHER)
				.checkValue(value)
				.isItOn();
	}

	public String concatString(String value1, String value2) {
		if (getSwitcher(MY_SWITCHER).isItOn()) {
			return value1 + " - " + value2;
		}

		return String.format("%s - %s", value1, value2);
	}

}
