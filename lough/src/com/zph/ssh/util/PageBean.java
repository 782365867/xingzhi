package com.zph.ssh.util;

import java.util.List;

import com.zph.ssh.entities.Course;
import com.zph.ssh.entities.CourseChoose;

public class PageBean {
	private List<Course> courseList;
	private List<CourseChoose> list; // Ҫ���ص�ĳһҳ�ļ�¼�б�
	private int allRow; // �ܼ�¼��
	private int totalPage; // ��ҳ��
	private int currentPage; // ��ǰҳ
	private int pageSize; // ÿҳ�ļ�¼��
	private boolean isFirstPage; // �Ƿ�Ϊ��ǰ��һҳ
	private boolean isLastPage; // �Ƿ�Ϊ���һҳ
	private boolean hasPreviousPage; // �Ƿ���ǰһҳ
	private boolean hasNextPage; // �Ƿ�����һҳ

	public void init() {
		this.isFirstPage = isFirstPage;
		this.isLastPage = isLastPage;
		this.hasPreviousPage = hasPreviousPage;
		this.hasNextPage = hasNextPage;
	}

	public static int countTatalPage(final int pageSize, final int allRow) {
		int toalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow
				/ pageSize + 1;
		return toalPage;
	}

	public static int countOffset(final int pageSize, final int currentPage) {
		final int offset = pageSize * (currentPage - 1);
		return offset;
	}

	public static int countCurrentPage(int page) {
		final int curpage = (page == 0 ? 1 : page);
		return curpage;
	}

	public int getAllRow() {
		return allRow;
	}

	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public List<CourseChoose> getList() {
		return list;
	}

	public void setList(List<CourseChoose> list) {
		this.list = list;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

}
