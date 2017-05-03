package com.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
