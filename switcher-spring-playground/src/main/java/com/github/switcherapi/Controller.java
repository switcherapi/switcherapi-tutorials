package com.github.switcherapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.github.switcherapi.config.Features.MY_SWITCHER;
import static com.github.switcherapi.config.Features.getSwitcher;

@RestController
@RequestMapping("api")
class Controller {

	@GetMapping(value = "/check")
	public ResponseEntity<Boolean> check(@RequestParam(required = false) String input) {
		boolean res = getSwitcher(MY_SWITCHER)
				.checkValue(input)
				.isItOn();
		
		return ResponseEntity.ok(res);
	}

}
