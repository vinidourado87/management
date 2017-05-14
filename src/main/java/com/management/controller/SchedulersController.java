package com.management.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
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
    public List<Resource<Schedule>> list() {
        List<Resource<Schedule>> resources = new ArrayList<Resource<Schedule>>();

        service.list().forEach(schedule -> {
            Resource<Schedule> resource = new Resource<Schedule>(schedule);
            resource.add(linkTo(methodOn(SchedulersController.class).find(schedule.getId())).withRel("find"));
            resources.add(resource);
        });

        return resources;
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
