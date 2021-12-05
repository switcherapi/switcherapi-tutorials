package com.github.switcherapi;

import static com.github.switcherapi.PlaygroundFeatures.MY_SWITCHER;

import com.github.switcherapi.client.model.Switcher;

public class AppPlayground {

	public static void main(String[] args) {
		System.out.println(new AppPlayground().myFeatureParams("user_1"));
	}
	
	public boolean myFeature() {
		Switcher switcher = PlaygroundFeatures.getSwitcher(MY_SWITCHER);
		return switcher.isItOn();
	}
	
	public boolean myFeatureParams(String value) {
		return PlaygroundFeatures
				.getSwitcher(MY_SWITCHER)
				.checkValue(value)
				.throttle(1000)
				.isItOn();
	}

}
