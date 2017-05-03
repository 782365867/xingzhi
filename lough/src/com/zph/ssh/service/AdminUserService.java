package com.zph.ssh.service;

import com.zph.ssh.dao.AdminUserDao;
import com.zph.ssh.entities.AdminUser;

public class AdminUserService {
	private AdminUserDao adminUserDao;

	public AdminUser getAdminUser(String adminName) {
		return adminUserDao.getByUserName(adminName);
	}

	public AdminUserDao getAdminUserDao() {
		return adminUserDao;
	}

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

}
