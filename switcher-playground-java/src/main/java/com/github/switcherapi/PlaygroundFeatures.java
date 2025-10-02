package com.github.switcherapi;

import com.switcherapi.client.SwitcherContext;
import com.switcherapi.client.SwitcherKey;

public class PlaygroundFeatures extends SwitcherContext {
	
	@SwitcherKey
	public static final String MY_SWITCHER = "MY_SWITCHER";
	
	@SwitcherKey
	public static final String NOT_CONFIGURED = "NOT_CONFIGURED";
	
}
