package com.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.model.Schedule;
import com.management.service.ScheduleService;

@RestController
@RequestMapping("/schedulers")
public class SchedulersController {

	@Autowired
	private ScheduleService service;
	
	@RequestMapping("")
    public List<Schedule> list() {
        return service.list();
    }

	@RequestMapping("/{id}")
    public Schedule find(@PathVariable("id") Long id) {
        return service.find(id);
    }
	
	@PostMapping("")
	public void create(@RequestBody Schedule schedule) {
		service.save(schedule);
	}
}
