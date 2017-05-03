package com.zph.ssh.entities;

import java.util.Date;

public class Project {

	private Integer id;
	private String projectId;
	private String projectName;

	private Date startTime;
	private Date overTime;
	
	private Integer numberLimit;
	private Integer number;
	private String remarks;
	
	private Integer payState;//默认0未交费，1为已交费
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getOverTime() {
		return overTime;
	}

	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}

	public Integer getNumberLimit() {
		return numberLimit;
	}

	public void setNumberLimit(Integer numberLimit) {
		this.numberLimit = numberLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectId=" + projectId
				+ ", projectName=" + projectName + ", startTime=" + startTime
				+ ", overTime=" + overTime + ", numberLimit=" + numberLimit
				+ ", number=" + number + ", remarks=" + remarks + ", payState="
				+ payState + "]";
	}

	public Integer getPayState() {
		return payState;
	}

	public void setPayState(Integer payState) {
		this.payState = payState;
	}

}
