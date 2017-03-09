package com.visionrun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public Object helloWorld(){
		return "Hello world.世界如此美好！！";
	}
}
