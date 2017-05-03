package com.zph.ssh.service;

import com.zph.ssh.dao.TeacherDao;
import com.zph.ssh.entities.Teacher;

public class TeacherService {
	private TeacherDao teacherDao;

	public void saveOrUpdate(Teacher teacher) {
		teacherDao.saveOrUpdate(teacher);
	}

	public Teacher getByTeacherName(String teacherName) {
		return teacherDao.getByTeacherName(teacherName);
	}

	public Teacher get(Integer id) {
		return teacherDao.get(id);
	}

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

}
