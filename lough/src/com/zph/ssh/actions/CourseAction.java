package com.zph.ssh.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.zph.ssh.entities.Course;
import com.zph.ssh.entities.CourseChoose;
import com.zph.ssh.entities.Teacher;
import com.zph.ssh.service.CourseService;
import com.zph.ssh.service.TeacherService;
import com.zph.ssh.util.PageBean;

public class CourseAction extends ActionSupport implements Preparable,
		RequestAware, ModelDriven<CourseChoose>, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CourseService courseService;
	private Integer id;
	private Course course;
	private CourseChoose courseChoose;
	private Teacher teacher;
	private TeacherService teacherService;

	public String list1() {
		System.out.println(session.get("username") + "5556666666666666666");
		System.out.println("0");
		request.put("courses1", courseService.getAllByFlag(1));
		System.out.println("2");
		System.out.println("usernameaction" + session.get("username")
				+ "------username");
		request.put("chooses", courseService
				.getChoosesByTeacherId((String) session.get("username")));
		return "list1";
	}

	public String list2() {
		request.put("courses2", courseService.getAllByFlag(2));
		request.put("chooses", courseService
				.getChoosesByTeacherId((String) session.get("username")));
		return "list2";
	}

	public String list3() {
		request.put("courses3", courseService.getAllByFlag(3));
		request.put("chooses", courseService
				.getChoosesByTeacherId((String) session.get("username")));
		return "list3";
	}

	public String listAdm() {
		request.put("chooses", courseService.getChooseAll());
		return "listAdm";
	}

	public String save() {
		// courseChoose.setCourse(course);

		model.setDate(new Date());
		teacher = teacherService.getByTeacherName((String) session
				.get("username"));
		model.setTeacher(teacher);

		// 鏃犳璇撅紝鏈弧涓夐棬
		/*
		 * System.out.println("<鍏冪礌>" +
		 * courseService.getChooseByCourseId(model.getCourse().getId()));
		 * System.out.println("courseChooseList" + courseChooseList);
		 * System.out.println(courseChooseList.contains(courseService
		 * .getChooseByCourseId(model.getCourse().getId())));
		 */
		ArrayList<CourseChoose> courseChooseList = new ArrayList<CourseChoose>();
		courseChooseList = (ArrayList<CourseChoose>) courseService
				.getChoosesByTeacherId((String) session.get("username"));//
		if (courseChooseList.contains(courseService.getChooseByCourseId(model
				.getCourse().getId(), (String) session.get("username")))
				|| courseChooseList.size() > 2) {
		} else if (teacherService.getByTeacherName((String) session
				.get("username")) == null) {
			return "noteacher";
		} else {
			courseService.saveOrUpdate(model);
		}
		return "save";
	}

	public void prepareSave() {

		model = new CourseChoose();
	}

	public String cancel() {
		System.out.println(id + "id+++++++++++++++++");
		courseService.delete(id);
		return "cancel";
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;

	}

	@Override
	public void prepare() throws Exception {

	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CourseChoose getCourseChoose() {
		return courseChoose;
	}

	public void setCourseChoose(CourseChoose courseChoose) {
		this.courseChoose = courseChoose;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	private PageBean pageBean; // 封装了分页信息和数据内容的pageBean
	private List<CourseChoose> listChoose;// 用于储存pageBean当中被封装的User信息
	private int page = 1; // 表示从网页中返回的当前页的值 默认为1 表示默认显示第一页内容
	private List<Course> listCourse;

	public List<CourseChoose> getListChoose() {
		return listChoose;
	}

	public void setListChoose(List<CourseChoose> listChoose) {
		this.listChoose = listChoose;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public List<Course> getListCourse() {
		return listCourse;
	}

	public void setListCourse(List<Course> listCourse) {
		this.listCourse = listCourse;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public void setService(CourseService courseService) {
		this.courseService = courseService;
	}

	public String listChooseByCourseOrderByCount() {

		final String hql = "From Course c Where c.count >=1 ORDER BY  c.flag ASC,c.count DESC";
		// final String hql =
		// "SELECT c,COUNT(*) AS cid From CourseChoose c where c.course.flag = 1 GROUP BY c.course ORDER BY cid DESC";
		this.pageBean = courseService.queryForPageOrder(hql, 5, page);// 获取封装了分页信息和数据的pageBean
		this.listCourse = this.pageBean.getCourseList(); // 获取数据

		request.put("courses", listCourse);
		return "listChooseByCourseOrderByCount";
	}

	public String listChooseAll() throws Exception {
		final String hql = "From CourseChoose";
		this.pageBean = courseService.queryForPage(hql, 5, page);// 获取封装了分页信息和数据的pageBean
		this.listChoose = this.pageBean.getList(); // 获取数据

		request.put("chooses", listChoose);
		return "listChooseAll";
	}

	private CourseChoose model = null;

	@Override
	public CourseChoose getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}
