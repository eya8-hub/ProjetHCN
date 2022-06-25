package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ResponseBody
public class PagesController {
    @RequestMapping("/a")
	public String index() {
    return "hello word";	
    }

    @RequestMapping("/b")
	public String index1() {
    return "heloo";	
    }
}
