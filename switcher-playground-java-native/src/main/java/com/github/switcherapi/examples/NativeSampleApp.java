package com.github.switcherapi.examples;

import com.switcherapi.client.SwitcherContextBase;

public class NativeSampleApp extends SwitcherContextBase {

    public static final String FEATURE_FLAG = "MY_SWITCHER";

    private final String valueParam = System.getenv("VALUE_PARAM");

    public void setupClient() {
        super.registerSwitcherKeys(FEATURE_FLAG);
        super.configureClient("switcherapi");
    }
	
	public void run() {
        var switcher = getSwitcher(FEATURE_FLAG);
        var flag = switcher.checkValue(this.valueParam).submit();
        System.out.println(flag.toString());
	}
	
	public static void main(String[] args) {
		NativeSampleApp nativeSampleApp = new NativeSampleApp();
		nativeSampleApp.setupClient();
		nativeSampleApp.run();
	}

}
