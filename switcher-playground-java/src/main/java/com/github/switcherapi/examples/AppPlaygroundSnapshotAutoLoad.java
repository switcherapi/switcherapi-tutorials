package com.github.switcherapi.examples;

import com.github.switcherapi.PlaygroundBaseFeatures;
import com.switcherapi.client.ContextBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.github.switcherapi.PlaygroundBaseFeatures.MY_SWITCHER;
import static com.switcherapi.client.SwitcherContextBase.*;

/**
 * This example shows how Auto Load Snapshot feature works.
 * <p>
 * Snapshot Auto Load will load the state of the switcher from a snapshot file when the client is initialized.
 * This feature is helpful when you want to start the application with a predefined state of a switcher.
 */
public class AppPlaygroundSnapshotAutoLoad {

	private static final Logger logger = LogManager.getLogger(AppPlaygroundSnapshotAutoLoad.class);

	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	static void main() {
		configure(ContextBuilder.builder()
				.context(PlaygroundBaseFeatures.class.getName())
				.domain(System.getenv("DOMAIN"))
				.url(System.getenv("URL"))
				.apiKey(System.getenv("API_KEY"))
				.environment(System.getenv("ENVIRONMENT"))
				.component("switcher-playground")
				.snapshotLocation("./src/main/resources/snapshots")
				.snapshotAutoLoad(true)
				.local(true));

		initializeClient();
		scheduler.scheduleAtFixedRate(() ->
				logger.info(getSwitcher(MY_SWITCHER).isItOn()), 0, 5, TimeUnit.SECONDS);
	}

}
