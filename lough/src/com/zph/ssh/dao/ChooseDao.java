package com.zph.ssh.dao;

import java.util.List;

import com.zph.ssh.entities.Course;
import com.zph.ssh.entities.CourseChoose;

public interface ChooseDao {
	public List<CourseChoose> queryForPage(final String hql, final int offset,
			final int length);

	public List<Course> queryForPageOrder(final String hql, final int offset,
			final int length);

	public int getAllRowCount(String hql);
}
