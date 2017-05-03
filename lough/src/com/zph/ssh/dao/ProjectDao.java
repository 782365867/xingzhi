package com.zph.ssh.dao;

import java.util.List;

import com.zph.ssh.entities.Project;

public class ProjectDao extends BaseDao {

	public void saveOrUpdate(Project project) {
		getSession().saveOrUpdate(project);
	}

	public List getAll() {
		String hql = "From Project";
		return getSession().createQuery(hql).list();
	}

	public Project get(Integer id) {
		return (Project) getSession().get(Project.class, id);
	}

	public Project getById(Integer id) {
		String hql = "From Project p where p.id = ?";
		return (Project) getSession().createQuery(hql).uniqueResult();
	}
}
