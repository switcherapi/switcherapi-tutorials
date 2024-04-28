package com.github.switcherapi.examples;

import com.github.switcherapi.PlaygroundBaseFeatures;
import com.github.switcherapi.client.ContextBuilder;

import static com.github.switcherapi.PlaygroundBaseFeatures.*;

/**
 * This example uses ${@link com.github.switcherapi.PlaygroundBaseFeatures} class,
 * which inherits from ${@link com.github.switcherapi.client.SwitcherContextBase}.
 * <p>
 * When we use SwitcherContextBase, all SDK settings needs to be configured manually.
 * This option is more flexible and allows us to configure the SDK in a more customized way.
 */
public class AppPlaygroundContextBase {

	public static void main(String[] args) {
		configure(ContextBuilder.builder()
				.contextLocation(PlaygroundBaseFeatures.class.getName())
				.snapshotLocation("./src/main/resources/snapshots")
				.local(true));
		
		initializeClient();
		getSwitcher(MY_SWITCHER).isItOn();
	}

}
