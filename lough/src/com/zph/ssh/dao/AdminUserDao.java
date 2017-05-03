package com.zph.ssh.dao;

import org.hibernate.Query;

import com.zph.ssh.entities.AdminUser;

public class AdminUserDao extends BaseDao {
	public AdminUser getByUserName(String adminName) {
		String hql = "FROM AdminUser au WHERE au.adminName = ?";
		Query query = getSession().createQuery(hql).setString(0, adminName);

		return (AdminUser) query.uniqueResult();
	}
}
