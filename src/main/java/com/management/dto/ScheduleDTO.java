package com.management.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ScheduleDTO implements Serializable {

	private static final long serialVersionUID = 7443399124723484531L;

	private Long id;

	private Date createdAt;

	private Date updatedAt;

	private Date dueDate;

	private Date resolvedAt;

	private String title;

	private String description;

	private Integer priority;

	private String status;

}
