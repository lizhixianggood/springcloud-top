package com.test.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class App2Application {
	public static void main(String[] args) {
		SpringApplication.run(App2Application.class, args);
	}
	
	@RestController
	class EchoController {

		@GetMapping("/echo/{string}")
		public String echo(@PathVariable String string) {
			return "app2++++" + string;
		}

		@GetMapping("/divide")
		public String divide(@RequestParam Integer a, @RequestParam Integer b) {
			return String.valueOf(a / b);
		}
		

		@GetMapping("/test2")
		public String test2() {
			return "test2ssss";
		}

	}
}
