package com.github.switcherapi.config;

import static com.github.switcherapi.client.SwitcherContextBase.*;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.switcherapi.client.ContextBuilder;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "switcher")
@Data
public class SwitcherConfig {
	
	private String apikey;
	private String domain;
	private String component;
	private Boolean offline;
	private SnapshotConfig snapshot;
	
	@Data
	static class SnapshotConfig {
		private String location;
		private Boolean auto;
	}
	
	@Bean
	public void configureSwitcher() {
		configure(ContextBuilder.builder()
				.contextLocation(Features.class.getName())
				.apiKey(apikey)
				.domain(domain)
				.component(component)
				.offlineMode(offline)
				.snapshotLocation(snapshot.getLocation())
				.snapshotAutoLoad(snapshot.getAuto()));
		
		initializeClient();
		watchSnapshot();
	}

}
