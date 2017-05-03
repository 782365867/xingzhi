package com.zph.ssh.dao;

import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Request;
import org.apache.jasper.tagplugins.jstl.core.Choose;
import org.apache.struts2.interceptor.SessionAware;

import com.zph.ssh.actions.LoginAction;
import com.zph.ssh.entities.Course;
import com.zph.ssh.entities.CourseChoose;

public class CourseDao extends BaseDao implements SessionAware {

	public List<Course> getAllByFlag(Integer id) {
		String hql = "From Course c where c.flag = ?";
		return getSession().createQuery(hql).setInteger(0, id).list();

	}

	public void delete(Integer id) {
		String hql = "Delete From CourseChoose c where c.id =?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}

	public void saveOrUpdate(CourseChoose courseChoose) {
		getSession().saveOrUpdate(courseChoose);
	}

	public CourseChoose getChoose(Integer id) {
		return (CourseChoose) getSession().get(CourseChoose.class, id);
	}

	public List<CourseChoose> getChoosesByTeacherId(String username) {
		System.out.println("3");
		String hql = "From CourseChoose c where  c.teacher.teacherName ="
				+ username;
		return getSession().createQuery(hql).list();
	}

	public CourseChoose getChoosesByCourseId(Integer id, String username) {
		String hql = "From CourseChoose c where c.course.id =? and c.teacher.teacherName ="
				+ username;
		return (CourseChoose) getSession().createQuery(hql).setInteger(0, id)
				.uniqueResult();
	}

	public Course get(Integer id) {
		return (Course) getSession().get(Course.class, id);
	}

	public List<CourseChoose> getChooseAll() {
		String hql = "From CourseChoose";
		return getSession().createQuery(hql).list();
	}

	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}
