package com.github.switcherapi;

import com.github.switcherapi.client.model.StrategyValidator;
import com.github.switcherapi.client.test.SwitcherTest;
import com.github.switcherapi.client.test.SwitcherTestWhen;
import com.github.switcherapi.config.Features;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringPlaygroundApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@SwitcherTest(key = Features.MY_SWITCHER, result = false)
	void shouldReturnFalse() throws Exception {
		this.mockMvc.perform(get("/api/check"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("false")));
	}

	@SwitcherTest(key = Features.MY_SWITCHER)
	void shouldReturnTrue() throws Exception {
		this.mockMvc.perform(get("/api/check"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("true")));
	}

	@SwitcherTest(key = Features.MY_SWITCHER,
			when = @SwitcherTestWhen(input = "valid", strategy = StrategyValidator.VALUE))
	void shouldReturnTrueGivenValidEntryCriteria() throws Exception {
		this.mockMvc.perform(get("/api/check?input=valid"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("true")));
	}

	@SwitcherTest(key = Features.MY_SWITCHER,
			when = @SwitcherTestWhen(input = "valid", strategy = StrategyValidator.VALUE))
	void shouldReturnFalseGivenInvalidEntryCriteria() throws Exception {
		this.mockMvc.perform(get("/api/check?input=invalid"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("false")));
	}

	@SwitcherTest(key = Features.MY_SWITCHER)
	void shouldReturnSwitcherResult() throws Exception {
		this.mockMvc.perform(get("/api/submit"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("\"switcherKey\":\"MY_SWITCHER\"")))
				.andExpect(content().string(containsString("\"reason\":\"Switcher bypassed\"")))
				.andExpect(content().string(containsString("\"itOn\":true")));
	}

}
