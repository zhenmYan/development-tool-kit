package com.yzm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/3  19:25
 */
@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	public String helloWorld(){
		return "hello World";
	}
}
