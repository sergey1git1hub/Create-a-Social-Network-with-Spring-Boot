package com.caveofprogramming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

}
