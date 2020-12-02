package com.moon.moon_security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
public class LoginPageConfig {

	@RequestMapping("/")
	public RedirectView loginPage() {
		log.info("login");
		return new RedirectView("/login.html");
	}
}
