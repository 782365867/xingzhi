package com.zph.ssh.entities;

import java.util.Date;

public class ApplySimple {
	private Integer id;
	private String name;// 姓名
	private Date subTime;// 提交时间

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

	public Date getSubTime() {
		return subTime;
	}

	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}

	@Override
	public String toString() {
		return "ApplySimple [id=" + id + ", name=" + name + ", subTime="
				+ subTime + "]";
	}

}
