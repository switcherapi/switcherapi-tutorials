package com.github.switcherapi;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.github.switcherapi.client.SwitcherMock;
import com.github.switcherapi.config.Features;

@SpringBootTest
@AutoConfigureMockMvc
class SpringPlaygroundApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@ParameterizedTest
	@SwitcherMock(key = Features.MY_SWITCHER, result = false)
	void shouldReturnFalse() throws Exception {
		this.mockMvc.perform(get("/api/check"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("false")));
	}
	
	@ParameterizedTest
	@SwitcherMock(key = Features.MY_SWITCHER, result = true)
	void shouldReturnTrue() throws Exception {
		this.mockMvc.perform(get("/api/check"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("true")));
	}

}
