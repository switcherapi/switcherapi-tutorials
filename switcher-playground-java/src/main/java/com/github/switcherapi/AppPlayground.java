package com.github.switcherapi;

import static com.github.switcherapi.PlaygroundFeatures.MY_SWITCHER;

import com.github.switcherapi.client.model.Switcher;

public class AppPlayground {

	public static void main(String[] args) {
		System.out.println(new AppPlayground().myFeatureParams());
	}
	
	public boolean myFeature() {
		Switcher switcher = PlaygroundFeatures.getSwitcher(MY_SWITCHER);
		return switcher.isItOn();
	}
	
	public boolean myFeatureParams() {
		return PlaygroundFeatures
				.getSwitcher(MY_SWITCHER)
				.checkValue("user_1")
				.isItOn();
	}

}
