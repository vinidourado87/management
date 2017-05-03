package com.management.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="schedule", schema="public")
public class Schedule implements Serializable {

	private static final long serialVersionUID = 3198670795248738123L;

	@Id
    @Column(name="id")
    @GeneratedValue(strategy= IDENTITY )
    private Long id;

	@Column(name="created_at")
	private Date createdAt;

	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="due_date")
	private Date dueDate;

	@Column(name="resolved_at")
	private Date resolvedAt;

	@Column(name="title")
	private String title;

	@Column(name="description")
	private String description;

	@Column(name="priority")
	private Integer priority;

	@Column(name="status")
	private String status;

}
