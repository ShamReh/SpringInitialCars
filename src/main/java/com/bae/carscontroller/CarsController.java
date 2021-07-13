package com.bae.carscontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarsController {

	@GetMapping("/") // MAPS a GET request to "/" to this method
	public String hello() {
		return "Hello, World!";
	}

}
