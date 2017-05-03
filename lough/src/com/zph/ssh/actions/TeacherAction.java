package com.zph.ssh.actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.zph.ssh.entities.Teacher;
import com.zph.ssh.service.DepartmentService;
import com.zph.ssh.service.TeacherService;

public class TeacherAction extends ActionSupport implements Preparable,
		ModelDriven<Teacher>, RequestAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Teacher model;
	private Integer id;
	private DepartmentService departmentService;
	private TeacherService teacherService;
	private Teacher teacher;

	public String input() {
		request.put("departments", departmentService.getAll());
		ActionContext
				.getContext()
				.getValueStack()
				.push(teacherService.getByTeacherName((String) session
						.get("username")));
		return "input";
	};

	public String save() {
		System.out.println(model);
		teacherService.saveOrUpdate(model);
		return "save";
	}

	public void prepareSave() {
		if ((teacherService.getByTeacherName((String) session.get("username")) == null)) {
			model = new Teacher();
		} else {
			model = teacherService.getByTeacherName((String) session
					.get("username"));
			System.out.println(model);
		}
		model.setName((String) session.get("name"));
		model.setTeacherName((String) session.get("username"));
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	@Override
	public Teacher getModel() {
		return model;
	}

	@Override
	public void prepare() throws Exception {

	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
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

	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}
