package com.management.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.model.Schedule;
import com.management.repository.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;

	public Schedule find(Long id) {
		return scheduleRepository.findOne(id);
	}
	
	public List<Schedule> list() {
		return scheduleRepository.findAll();
	}

	public Schedule save(Schedule schedule) {
		schedule.setCreatedAt(new Date());
		schedule.setUpdatedAt(new Date());
		Schedule scheduleSaved = scheduleRepository.save(schedule);
		scheduleRepository.flush();
		return scheduleSaved;
	}

	public void update(Schedule schedule) {
		schedule.setUpdatedAt(new Date());
		scheduleRepository.saveAndFlush(schedule);
	}

	public void delete(Long id) {
		scheduleRepository.delete(id);
	}
}
