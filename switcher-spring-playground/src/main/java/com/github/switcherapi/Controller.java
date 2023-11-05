package com.github.switcherapi;

import jakarta.ws.rs.QueryParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.switcherapi.config.Features.MY_SWITCHER;
import static com.github.switcherapi.config.Features.getSwitcher;

@RestController
@RequestMapping("api")
class Controller {

	@GetMapping(value = "/check")
	public ResponseEntity<Boolean> check(@QueryParam("input") String input) {
		boolean res = getSwitcher(MY_SWITCHER)
				.checkValue(input)
				.isItOn();
		
		return ResponseEntity.ok(res);
	}

}
