package com.github.switcherapi.examples;

import static com.github.switcherapi.PlaygroundBaseFeatures.*;

import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;

import com.github.switcherapi.PlaygroundBaseFeatures;
import com.github.switcherapi.client.ContextBuilder;

/**
 * This example uses ${@link com.github.switcherapi.PlaygroundBaseFeatures} class,
 * which inherits from ${@link com.github.switcherapi.client.SwitcherContextBase}.
 *
 * When we use SwitcherContextBase, all SDK settings needs to be configured manually.
 * This option is more flexible and allows us to configure the SDK in a more customized way.
 */
public class AppPlaygroundContextBase {
	
	private static final String SNAPSHOTS_LOCAL = Paths
			.get(StringUtils.EMPTY)
			.toAbsolutePath() + "/src/main/resources/snapshots";

	public static void main(String[] args) {
		configure(ContextBuilder.builder()
				.contextLocation(PlaygroundBaseFeatures.class.getName())
				.snapshotLocation(SNAPSHOTS_LOCAL)
				.offlineMode(true));
		
		initializeClient();
		getSwitcher(MY_SWITCHER).isItOn();
	}

}
