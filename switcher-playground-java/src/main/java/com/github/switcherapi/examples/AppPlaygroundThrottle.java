package com.github.switcherapi.examples;

import static com.github.switcherapi.PlaygroundFeatures.MY_SWITCHER;
import static com.github.switcherapi.client.SwitcherContext.getSwitcher;

import com.github.switcherapi.client.model.Switcher;

/**
 * This example shows how to use the throttle feature.
 * <p>
 * Throttling is a feature that allows you to limit the number of times a switcher is fetched from a remote server.
 * This can dramatically improve performance for critical code paths, especially if the remote server is slow or unreachable.
 */
public class AppPlaygroundThrottle {

	public static void main(String[] args) {
		final Switcher feature = getSwitcher(MY_SWITCHER)
				.throttle(1000);
		
		for (int i = 0; i < 20; i++) {
			feature.isItOn();
		}
	}

}
