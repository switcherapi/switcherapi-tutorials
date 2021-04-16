package com.github.switcherapi;

import com.github.switcherapi.client.SwitcherContext;
import com.github.switcherapi.client.configuration.SwitcherKey;

public class PlaygroundFeatures extends SwitcherContext {
	
	@SwitcherKey
	public static final String MY_SWITCHER = "MY_SWITCHER";
	
	@SwitcherKey
	public static final String NON_CONFIGURED = "NON_CONFIGURED";
	
}
