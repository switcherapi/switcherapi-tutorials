package com.github.switcherapi.examples;

import static com.github.switcherapi.PlaygroundFeatures.MY_SWITCHER;
import static com.github.switcherapi.client.SwitcherContext.getSwitcher;

import com.github.switcherapi.client.model.Switcher;

public class AppPlaygroundThrottle {

	public static void main(String[] args) {
		final Switcher feature = getSwitcher(MY_SWITCHER)
				.throttle(1000)
				.build();
		
		for (int i = 0; i < 20; i++) {
			feature.isItOn();
		}
	}

}
