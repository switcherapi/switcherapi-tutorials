package com.github.switcherapi;

import static com.github.switcherapi.MyAppFeatures.MY_SWITCHER;

import com.github.switcherapi.client.model.Switcher;

public class Playground {

	public static void main(String[] args) {
		new Playground().run();
	}
	
	public void run() {
		Switcher switcher = MyAppFeatures.getSwitcher(MY_SWITCHER);
		switcher.setShowReason(true);
		System.out.println(switcher.isItOn());
	}
	
	public boolean myFeature() {
		Switcher switcher = MyAppFeatures.getSwitcher(MY_SWITCHER);
		return switcher.isItOn();
	}

}