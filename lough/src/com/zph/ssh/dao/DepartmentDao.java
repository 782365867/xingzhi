package com.zph.ssh.dao;

import java.util.List;

import com.zph.ssh.entities.Department;

public class DepartmentDao extends BaseDao {
	public List<Department> getAll() {
		String hql = "FROM Department";
		return getSession().createQuery(hql).list();
	}
}
