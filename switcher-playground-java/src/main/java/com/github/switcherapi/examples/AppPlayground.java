package com.github.switcherapi.examples;

import static com.github.switcherapi.PlaygroundFeatures.*;

/**
 * This example uses ${@link com.github.switcherapi.PlaygroundFeatures} class,
 * which inherits from ${@link com.github.switcherapi.client.SwitcherContext}.
 * <p>
 * When we use SwitcherContext, all SDK settings are automatically loaded from switcherapi.properties file.
 * This option is perfect for clean code and fast development without introducing extra code.
 */
public class AppPlayground {

	public static void main(String[] args) {
		final AppPlayground app = new AppPlayground();

		System.out.println("With strategy entry: " + app.myFeatureParams("user_1"));
		System.out.println("No strategy entry: " + app.myFeature());
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
