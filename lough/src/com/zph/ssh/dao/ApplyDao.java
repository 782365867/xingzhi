package com.zph.ssh.dao;

import java.util.List;

import org.hibernate.Query;

import com.zph.ssh.entities.Apply;
import com.zph.ssh.entities.ApplySimple;
import com.zph.ssh.entities.Leave;

public class ApplyDao extends BaseDao {
	public ApplySimple getByName(String name) {
		/**
		 * 通过人名获取simple
		 * 
		 * @param name
		 * 
		 */
		System.out.println("dao");
		String hql = "From ApplySimple a where a.name = ?";
		Query query = getSession().createQuery(hql).setString(0, name);
		System.out.println("----------------"
				+ (ApplySimple) query.uniqueResult());
		return (ApplySimple) query.uniqueResult();
	}

	public Leave getLeaveByName(String name) {
		/**
		 * 通过人名获取leave
		 * 
		 * @param name
		 * 
		 */
		System.out.println("dao");
		System.out.println(name);
		String hql = "From Leave l where l.name = ?";
		Query query = getSession().createQuery(hql).setString(0, name);
		System.out.println((Leave) query.uniqueResult() + "=----------");
		return (Leave) query.uniqueResult();
	}

	public void saveOrUpdate(Leave leave) {
		getSession().saveOrUpdate(leave);
	}

	public void saveOrUpdate(Apply apply) {
		getSession().saveOrUpdate(apply);
	}

	public void saveOrUpdate(ApplySimple applySimple) {
		getSession().saveOrUpdate(applySimple);
	}

	public List<Apply> getAllByProject(Integer id) {

		String hql = "From Apply a where a.project.id =?";

		return getSession().createQuery(hql).setInteger(0, id).list();
	}

	public Apply get(Integer id) {

		return (Apply) getSession().get(Apply.class, id);
	}

}
