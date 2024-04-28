package com.github.switcherapi;

import com.github.switcherapi.client.SwitcherExecutor;
import com.github.switcherapi.client.exception.SwitcherException;
import com.github.switcherapi.client.test.SwitcherTest;
import com.github.switcherapi.examples.AppPlayground;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.switcherapi.PlaygroundFeatures.MY_SWITCHER;
import static org.junit.jupiter.api.Assertions.*;

class AppPlaygroundTest {
	
	private AppPlayground playground;
	
	@BeforeEach
	void setUp() {
		playground = new AppPlayground();
	}

	@SwitcherTest(key = MY_SWITCHER)
	void testMyFeatureUsingParameter() {
		assertTrue(playground.myFeature());
	}
	
	@Test
	void testMyFeatureNotUsingParameter() {
		SwitcherExecutor.assume(MY_SWITCHER, true);
		assertTrue(playground.myFeature());
		SwitcherExecutor.forget(MY_SWITCHER);
		assertFalse(playground.myFeature());
	}
	
	@Test
	void testMyFeatureReadingFromSnapshot() {
		assertFalse(playground.myFeature());
	}
	
	@Test
	void testSwitchers() {
		assertThrows(SwitcherException.class, PlaygroundFeatures::checkSwitchers);
	}

	@SwitcherTest(key = MY_SWITCHER, abTest = true)
	void testAbSwitchers() {
		assertEquals("value1 - value2", playground.concatString("value1", "value2"));
	}

}
