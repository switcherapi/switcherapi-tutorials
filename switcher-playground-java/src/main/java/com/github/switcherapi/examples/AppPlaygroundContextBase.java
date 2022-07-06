package com.github.switcherapi.examples;

import static com.github.switcherapi.PlaygroundBaseFeatures.*;

import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;

import com.github.switcherapi.PlaygroundBaseFeatures;
import com.github.switcherapi.client.ContextBuilder;

public class AppPlaygroundContextBase {
	
	private static final String SNAPSHOTS_LOCAL = Paths
			.get(StringUtils.EMPTY)
			.toAbsolutePath()
			.toString() + "/src/main/resources/snapshots";

	public static void main(String[] args) {
		configure(ContextBuilder.builder()
				.contextLocation(PlaygroundBaseFeatures.class.getName())
				.snapshotLocation(SNAPSHOTS_LOCAL)
				.offlineMode(true));
		
		initializeClient();
		getSwitcher(MY_SWITCHER).isItOn();
	}

}
