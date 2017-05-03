package com.zph.ssh.dao;

import org.hibernate.Query;

import com.zph.ssh.entities.Teacher;

public class TeacherDao extends BaseDao {
	public void saveOrUpdate(Teacher teacher) {
		getSession().saveOrUpdate(teacher);
	}

	public Teacher get(Integer id) {
		return (Teacher) getSession().get(Teacher.class, id);
	}

	public Teacher getByTeacherName(String teacherName) {
		String hql = "FROM Teacher t Where t.teacherName = ?";
		Query query = getSession().createQuery(hql).setString(0, teacherName);
		return (Teacher) query.uniqueResult();
	}
}
