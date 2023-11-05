package com.github.switcherapi.examples;

import static com.github.switcherapi.PlaygroundBaseFeatures.*;

import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.switcherapi.PlaygroundBaseFeatures;
import com.github.switcherapi.client.ContextBuilder;
import com.github.switcherapi.client.exception.SwitcherException;
import com.github.switcherapi.client.utils.SnapshotEventHandler;

/**
 * This example shows how Watch Snapshot feature works.
 *
 * Snapshot Watcher will automatically reload the state of the switcher when the snapshot file is modified.
 * This feature is helpful when you want to change the state of a switcher without restarting the application.
 */
public class AppPlaygroundSnapshotWatch {
	
	private static final Logger logger = LogManager.getLogger(AppPlaygroundSnapshotWatch.class);

	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	private static final String SNAPSHOTS_LOCAL = Paths
			.get(StringUtils.EMPTY)
			.toAbsolutePath() + "/src/main/resources/snapshots";

	public static void main(String[] args) {
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

		scheduler.scheduleAtFixedRate(() -> getSwitcher(MY_SWITCHER).isItOn(), 0, 5, TimeUnit.SECONDS);
	}

}
