package com.github.switcherapi.examples;

import static com.github.switcherapi.PlaygroundBaseFeatures.*;

import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.switcherapi.PlaygroundBaseFeatures;
import com.github.switcherapi.client.ContextBuilder;
import com.github.switcherapi.client.exception.SwitcherException;
import com.github.switcherapi.client.utils.SnapshotEventHandler;

public class AppPlaygroundSnapshotWatch {
	
	private static final Logger logger = LogManager.getLogger(AppPlaygroundSnapshotWatch.class);
	
	private static final String SNAPSHOTS_LOCAL = Paths
			.get(StringUtils.EMPTY)
			.toAbsolutePath()
			.toString() + "/src/main/resources/snapshots";

	public static void main(String[] args) throws InterruptedException {
		configure(ContextBuilder.builder()
				.contextLocation(PlaygroundBaseFeatures.class.getName())
				.snapshotLocation(SNAPSHOTS_LOCAL)
				.offlineMode(true));
		
		initializeClient();
		watchSnapshot(new SnapshotEventHandler() {
			@Override
			public void onError(SwitcherException exception) {
				logger.info("ERROR: {}", exception.getMessage());
			}
			
			@Override
			public void onSuccess() {
				logger.info("SUCCESS");
			}
		});
		
		for (int i = 0; i < 5; i++) {
			getSwitcher(MY_SWITCHER).isItOn();
			Thread.sleep(5000);
			// In the meantime, try change /snapshots/default.json
		}
		
		stopWatchingSnapshot();
	}

}
