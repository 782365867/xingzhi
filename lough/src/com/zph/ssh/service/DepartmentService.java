package com.zph.ssh.service;

import java.util.List;

import com.zph.ssh.dao.DepartmentDao;
import com.zph.ssh.entities.Department;

public class DepartmentService {
	private DepartmentDao departmentDao;

	public List<Department> getAll() {
		return departmentDao.getAll();
	}

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

}
