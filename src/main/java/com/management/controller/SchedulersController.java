package com.management.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedulers")
public class SchedulersController {

	@RequestMapping("/")
    public List<String> list() {
        return Arrays.asList("list");
    }
	
	@RequestMapping("/{id}")
    public List<String> find() {
        return Arrays.asList("list");
    }
}
