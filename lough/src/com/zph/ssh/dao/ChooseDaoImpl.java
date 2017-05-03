package com.zph.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.zph.ssh.entities.Course;
import com.zph.ssh.entities.CourseChoose;

public class ChooseDaoImpl extends BaseDao implements ChooseDao {

	public int getAllRowCount(String hql) {
		return getSession().createQuery(hql).list().size();
	}

	@SuppressWarnings("unchecked")
	public List<CourseChoose> queryForPage(final String hql, final int offset,
			final int length) {
		Session session = this.getSession();
		Query q = session.createQuery(hql);

		q.setFirstResult(offset);
		q.setMaxResults(length);
		List<CourseChoose> list = q.list();

		return list;
	}

	@Override
	public List<Course> queryForPageOrder(String hql, int offset, int length) {
		String hql2 = "Select c.course,count(*) from CourseChoose c group by c.course";
		List<Object[]> list2 = getSession().createQuery(hql2).list();
		for (Object[] obj : list2) {
			((Course) obj[0])
					.setCount(Integer.parseInt(String.valueOf(obj[1])));
			System.out.println(obj[0] + "======" + obj[1]);
		}

		Session session = this.getSession();
		Query q = session.createQuery(hql);

		q.setFirstResult(offset);
		q.setMaxResults(length);
		List<Course> list = q.list();
		System.out.println("list" + list);

		return list;
	}

}
