package com.github.switcherapi.examples;

import com.github.switcherapi.PlaygroundBaseFeatures;
import com.switcherapi.client.ContextBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.github.switcherapi.PlaygroundBaseFeatures.*;

/**
 * This example uses ${@link com.github.switcherapi.PlaygroundBaseFeatures} class,
 * which inherits from ${@link com.switcherapi.client.SwitcherContextBase}.
 * <p>
 * When we use SwitcherContextBase, all SDK settings needs to be configured manually.
 * This option is more flexible and allows us to configure the SDK in a more customized way.
 */
public class AppPlaygroundContextBase {

	private static final Logger logger = LogManager.getLogger(AppPlaygroundContextBase.class);

	static void main() {
		configure(ContextBuilder.builder()
				.context(PlaygroundBaseFeatures.class.getName())
				.snapshotLocation("./src/main/resources/snapshots")
				.local(true));
		
		initializeClient();
		logger.info("Switcher {} is {} for user_1", MY_SWITCHER, getSwitcher(MY_SWITCHER).isItOn());
	}

}
