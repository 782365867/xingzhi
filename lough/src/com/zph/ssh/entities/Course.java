package com.zph.ssh.entities;

public class Course {
	private Integer id;// 代理主键
	private Integer courseId;// 课程代号
	private String name;// 课程名
	private String firstCatagory;// 一级分类（大），没有为null
	private String secondCatagory;// 二级分类（小）
	private Integer flag;// 表
	private Integer count;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstCatagory() {
		return firstCatagory;
	}

	public void setFirstCatagory(String firstCatagory) {
		this.firstCatagory = firstCatagory;
	}

	public String getSecondCatagory() {
		return secondCatagory;
	}

	public void setSecondCatagory(String secondCatagory) {
		this.secondCatagory = secondCatagory;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseId=" + courseId + ", name=" + name
				+ ", firstCatagory=" + firstCatagory + ", secondCatagory="
				+ secondCatagory + ", flag=" + flag + ", count=" + count + "]";
	}

}
