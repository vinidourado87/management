package com.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public Schedule create(@RequestBody Schedule schedule) {
		return service.save(schedule);
	}

	@PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Schedule schedule) {
		schedule.setId(id);
		service.update(schedule);
    }

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
