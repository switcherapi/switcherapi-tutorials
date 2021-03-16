package com.github.switcherapi;

import static com.github.switcherapi.MyAppFeatures.MY_SWITCHER;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import com.github.switcherapi.client.configuration.SwitcherMock;
import com.github.switcherapi.client.exception.SwitcherException;
import com.github.switcherapi.client.factory.SwitcherExecutor;

class PlaygroundTest {
	
	private Playground playground;
	
	@BeforeEach
	void setUp() {
		playground = new Playground();
	}
	
	@ParameterizedTest
	@SwitcherMock(key = MY_SWITCHER, result = true)
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
		assertThrows(SwitcherException.class, 
				() -> MyAppFeatures.checkSwitchers());
	}

}
