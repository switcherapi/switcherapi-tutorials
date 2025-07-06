package com.github.switcherapi;

import com.github.switcherapi.client.model.SwitcherResult;
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
		var res = getSwitcher(MY_SWITCHER)
				.checkValue(input)
				.isItOn();
		
		return ResponseEntity.ok(res);
	}

	@GetMapping(value = "/submit")
	public ResponseEntity<SwitcherResult> submit(@RequestParam(required = false) String input) {
		var res = getSwitcher(MY_SWITCHER)
				.checkValue(input)
				.submit();

		return ResponseEntity.ok(res);
	}

}
