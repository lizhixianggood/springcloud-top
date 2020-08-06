package com.test.usercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class UsercenterApplication {
	public static void main(String[] args) {
		SpringApplication.run(UsercenterApplication.class, args);
	}
	
	@RestController
	class EchoController {

		@GetMapping("/echo/{string}")
		public String echo(@PathVariable String string) {
			return "USERCENTER++++" + string;
		}

		@GetMapping("/divide")
		public String divide(@RequestParam Integer a, @RequestParam Integer b) {
			return String.valueOf(a / b);
		}
		
	}
}
