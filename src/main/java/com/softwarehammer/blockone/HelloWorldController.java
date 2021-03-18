package com.softwarehammer.blockone;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class HelloWorldController
{
	@RequestMapping("/api/hello")
	@ResponseBody
	public String sayHello() 
	{
		return "Hello World....";
	}
}
