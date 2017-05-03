package com.zph.ssh.entities;

import java.util.Date;

public class Leave {
	private Integer id;
	private String name;
	private String content;// 请假内容
	private Date subTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSubTime() {
		return subTime;
	}

	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}

	@Override
	public String toString() {
		return "Leave [id=" + id + ", name=" + name + ", content=" + content
				+ ", subTime=" + subTime + "]";
	}

}
