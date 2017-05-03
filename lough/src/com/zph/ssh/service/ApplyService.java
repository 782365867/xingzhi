package com.zph.ssh.service;

import java.util.List;

import com.zph.ssh.dao.ApplyDao;
import com.zph.ssh.entities.Apply;
import com.zph.ssh.entities.ApplySimple;
import com.zph.ssh.entities.Leave;

public class ApplyService {
	private ApplyDao applyDao;

	public ApplySimple get(String name) {
		return applyDao.getByName(name);
	}

	public Leave getLeave(String name) {

		return applyDao.getLeaveByName(name);
	}

	public void saveOrUpdate(Apply apply) {
		applyDao.saveOrUpdate(apply);
	}

	public void saveOrUpdate(Leave leave) {
		applyDao.saveOrUpdate(leave);
	}

	public ApplyDao getApplyDao() {
		return applyDao;
	}

	public void saveOrUpdate(ApplySimple applySimple) {
		applyDao.saveOrUpdate(applySimple);
	}

	public void setApplyDao(ApplyDao applyDao) {
		this.applyDao = applyDao;
	}

	public List<Apply> getAllByProject(Integer id) {

		return applyDao.getAllByProject(id);
	}

	public Apply get(Integer id) {
		return applyDao.get(id);
	}
}
