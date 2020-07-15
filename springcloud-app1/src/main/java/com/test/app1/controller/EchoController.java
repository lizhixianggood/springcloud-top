package com.test.app1.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController/* extends AbstractController */{

	@GetMapping("/echo/{string}")
	public String echo(@PathVariable String string) {
		return "auth++++" + string;
	}
	@GetMapping("/divide")
	public String divide(@RequestParam Integer a, @RequestParam Integer b) {
		return String.valueOf(a / b);
	}
	@GetMapping("/test")
	public String test(HttpServletRequest request) {
		String authorization = request.getHeader("user");
		return authorization+"ssssss";
	}
}
