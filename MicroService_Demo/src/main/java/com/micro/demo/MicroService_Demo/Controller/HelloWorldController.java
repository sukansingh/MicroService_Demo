package com.micro.demo.MicroService_Demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.micro.demo.bean.HelloWorld;

@RestController
public class HelloWorldController {

	@GetMapping(path="/hello-world")
	public String helloWorld() {
		
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean/{message}")
	public HelloWorld helloWorlBbean(@PathVariable String message) {
		
		return new HelloWorld(message);
	}
}
