package com.github.switcherapi.config;

import com.github.switcherapi.client.ContextBuilder;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static com.github.switcherapi.client.SwitcherContextBase.*;

@Configuration
@ConfigurationProperties(prefix = "switcher")
@Data
class SwitcherConfiguration {

	private String url;
	private String apikey;
	private String domain;
	private String component;
	private Boolean local;
	private SnapshotConfig snapshot;
	
	@Data
	static class SnapshotConfig {
		private String location;
		private Boolean auto;
		private String updateInterval;
	}

	@PostConstruct
	public void configureSwitcher() {
		configure(ContextBuilder.builder()
				.contextLocation(Features.class.getName())
				.url(url)
				.apiKey(apikey)
				.domain(domain)
				.component(component)
				.local(local)
				.snapshotLocation(snapshot.getLocation())
				.snapshotAutoUpdateInterval(snapshot.getUpdateInterval())
				.snapshotAutoLoad(snapshot.getAuto()));

		initializeClient();
		watchSnapshot();
	}

}
