package com.github.switcherapi.examples;

import static com.github.switcherapi.PlaygroundFeatures.MY_SWITCHER;
import static com.github.switcherapi.client.SwitcherContext.getSwitcher;

/**
 * This example uses ${@link com.github.switcherapi.PlaygroundFeatures} class,
 * which inherits from ${@link com.github.switcherapi.client.SwitcherContext}.
 *
 * When we use SwitcherContext, all SDK settings are automatically loaded from switcherapi.properties file.
 * This option is perfect for clean code and fast development without introducing extra code.
 */
public class AppPlayground {

	public static void main(String[] args) {
		final AppPlayground app = new AppPlayground();
		app.myFeatureParams("user_1");
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

}
