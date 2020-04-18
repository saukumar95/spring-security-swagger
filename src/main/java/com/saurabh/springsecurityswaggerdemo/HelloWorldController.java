package com.saurabh.springsecurityswaggerdemo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class HelloWorldController {

	@GetMapping("/")
	public String helloWorldMessage() {
		return "<h1>Hello World!</h1>";
	}

	@GetMapping("/user")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public String user() {
		return "<h1>Welcome User</h1>";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String admin() {
		return "<h1>Welcome Admin</h1>";
	}

}
