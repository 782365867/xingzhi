package com.zph.ssh.service;

import java.util.List;

import com.zph.ssh.dao.ProjectDao;
import com.zph.ssh.entities.Project;

public class ProjectService {
	public ProjectDao projectDao;

	public void saveOrUpdate(Project project) {
		projectDao.saveOrUpdate(project);
	}

	public List getAll() {
		return projectDao.getAll();
	}

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public Project get(Integer id) {
		return projectDao.get(id);
	}

}
