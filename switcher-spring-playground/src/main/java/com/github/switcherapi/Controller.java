package com.github.switcherapi;

import static com.github.switcherapi.config.Features.*;

import javax.ws.rs.QueryParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class Controller {

	@GetMapping(value = "/check")
	public ResponseEntity<Boolean> check(@QueryParam("input") String input) {
		boolean res = getSwitcher(MY_SWITCHER)
				.checkValue(input)
				.isItOn();
		
		return ResponseEntity.ok(res);
	}

}
