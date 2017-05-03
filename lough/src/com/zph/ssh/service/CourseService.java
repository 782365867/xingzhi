package com.zph.ssh.service;

import java.util.List;

import com.zph.ssh.dao.ChooseDao;
import com.zph.ssh.dao.CourseDao;
import com.zph.ssh.entities.Course;
import com.zph.ssh.entities.CourseChoose;
import com.zph.ssh.util.PageBean;

public class CourseService {
	private CourseDao courseDao;
	private ChooseDao chooseDao;

	public List<Course> getAllByFlag(Integer id) {
		return courseDao.getAllByFlag(id);
	}

	public PageBean queryForPage(String hql, int pageSize, int page) {

		int allRow = chooseDao.getAllRowCount(hql); // �ܼ�¼��
		int totalPage = PageBean.countTatalPage(pageSize, allRow); // ��ҳ��
		final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		final int length = pageSize; // ÿҳ��¼��
		final int currentPage = PageBean.countCurrentPage(page); // ��ǰҳ
		List list = chooseDao.queryForPage(hql, offset, length); //

		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	public PageBean queryForPageOrder(String hql, int pageSize, int page) {

		int allRow = chooseDao.getAllRowCount(hql); // �ܼ�¼��
		int totalPage = PageBean.countTatalPage(pageSize, allRow); // ��ҳ��
		final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		final int length = pageSize; // ÿҳ��¼��
		final int currentPage = PageBean.countCurrentPage(page); // ��ǰҳ
		List list = chooseDao.queryForPageOrder(hql, offset, length); //

		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setCourseList(list);
		pageBean.init();
		return pageBean;
	}

	public CourseChoose getChoose(Integer id) {
		return courseDao.getChoose(id);
	}

	public List<CourseChoose> getChoosesByTeacherId(String username) {
		System.out.println("service");
		return courseDao.getChoosesByTeacherId(username);
	}

	public CourseChoose getChooseByCourseId(Integer id, String username) {
		return courseDao.getChoosesByCourseId(id, username);
	}

	public void delete(Integer id) {
		courseDao.delete(id);
	}

	public Course get(Integer id) {
		return courseDao.get(id);
	}

	public void saveOrUpdate(CourseChoose courseChoose) {
		courseDao.saveOrUpdate(courseChoose);
	}

	public List<CourseChoose> getChooseAll() {
		return courseDao.getChooseAll();
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public ChooseDao getChooseDao() {
		return chooseDao;
	}

	public void setChooseDao(ChooseDao chooseDao) {
		this.chooseDao = chooseDao;
	}

}
