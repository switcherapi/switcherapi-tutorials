package com.github.switcherapi.config;

import com.switcherapi.client.SwitcherContextBase;
import com.switcherapi.client.SwitcherKey;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "switcher")
public class Features extends SwitcherContextBase {
	
	@SwitcherKey
	public static final String MY_SWITCHER = "MY_SWITCHER";

	@PostConstruct
	@Override
	protected void configureClient() {
		super.configureClient();
	}
}
