package com.zph.ssh.entities;

import java.util.Date;

public class CourseChoose {

	private Integer id;
	private Teacher teacher;
	private Course course;
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object arg0) {
		System.out.println("fp------------------------------------");
		if (arg0 != null && arg0 instanceof CourseChoose) {
			System.out.println(this.getId() + "this.getId()");
			System.out.println(((CourseChoose) arg0).getId()
					+ "((CourseChoose) arg0).getId()");
			return this.getId().equals(((CourseChoose) arg0).getId());
		}
		return false;
	}

	@Override
	public String toString() {
		return "CourseChoose [id=" + id + ", teacher=" + teacher + ", course="
				+ course + ", date=" + date + "]";
	}
}
