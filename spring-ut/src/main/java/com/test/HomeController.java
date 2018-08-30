package com.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	
	@RequestMapping("/")
	public @ResponseBody String getHello() {
		return "Hello World";
	}
	
	@RequestMapping("/hi")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format("Hi, %s!", name);
    }

}
