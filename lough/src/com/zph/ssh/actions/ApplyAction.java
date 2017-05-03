package com.zph.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.zph.ssh.entities.Apply;
import com.zph.ssh.entities.ApplySimple;
import com.zph.ssh.entities.Leave;
import com.zph.ssh.entities.Project;
import com.zph.ssh.entities.Teacher;
import com.zph.ssh.service.ApplyService;
import com.zph.ssh.service.ProjectService;
import com.zph.ssh.service.TeacherService;

public class ApplyAction extends ActionSupport implements RequestAware,
		ModelDriven<Apply>, Preparable, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Apply model;
	private ProjectService projectService;
	private Integer id;
	private Integer id2;
	private Project project;
	private LoginAction loginAction;
	private ApplyService applyService;
	private Teacher teacher;
	private TeacherService teacherService;
	private String name;
	private ApplySimple applysimple;
	private Leave leave;
	private InputStream inputStream;
	private String content;

	/**
	 * 4/16项目报名
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String simple() {
		String name1 = (String) session.get("name");

		System.out.println(name1 + "name1");
		if (applyService.get(name1) == null) {
			System.out.println("inputstream====0");
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			applysimple = new ApplySimple();
			applysimple.setName(name1);
			applysimple.setSubTime(new Date());
			applyService.saveOrUpdate(applysimple);
		} else {
			System.out.println("inputstream====1");
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println("inputstream====1");
		}
		return "ajax-success";
	}

	/**
	 * 请假
	 * 
	 * @return
	 */
	public String leave() {
		String name1 = (String) session.get("name");
		if (applyService.getLeave(name1) == null) {
			System.out.println("inputstream====0");
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println("inputstream====0");
			leave = new Leave();
			leave.setName(name1);
			leave.setSubTime(new Date());
			leave.setContent(content);
			applyService.saveOrUpdate(leave);
			System.out.println("inputstream====0");
		} else {
			System.out.println("inputstream====1");
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println("inputstream====1");
		}
		return "ajax-success";
	}

	public String apply() {
		project = projectService.get(id);
		model.setId(null);
		model.setProject(project);
		model.setSubmitTime(new Date());
		model.setTeacher(teacherService.getByTeacherName((String) session
				.get("username")));
		applyService.saveOrUpdate(model);
		return "apply";
	}

	public void prepareApply() {
		model = new Apply();
	}

	public String pay() {
		model.setPayState(1);
		applyService.saveOrUpdate(model);
		System.out.println("id" + model.getProject().getId());
		setId2(model.getProject().getId());
		return "pay";
	}

	public void preparePay() {
		model = applyService.get(id);
	}

	public String cancelpay() {
		model.setPayState(0);
		applyService.saveOrUpdate(model);
		System.out.println("id" + model.getProject().getId());
		setId2(model.getProject().getId());
		return "cancelpay";
	}

	public String isAppliedByIdAndUser() {
		return "";
	}

	public void prepareCancelpay() {
		model = applyService.get(id);
	}

	public String list() {

		System.out.println("apply-------------"
				+ applyService.getAllByProject(id));
		request.put("applys", applyService.getAllByProject(id));
		return "list";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public Leave getLeave() {
		return leave;
	}

	public void setLeave(Leave leave) {
		this.leave = leave;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public LoginAction getLoginAction() {
		return loginAction;
	}

	public void setLoginAction(LoginAction loginAction) {
		this.loginAction = loginAction;
	}

	public ApplyService getApplyService() {
		return applyService;
	}

	public ApplySimple getApplysimple() {
		return applysimple;
	}

	public void setApplysimple(ApplySimple applysimple) {
		this.applysimple = applysimple;
	}

	public void setApplyService(ApplyService applyService) {
		this.applyService = applyService;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
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

	public Integer getId2() {
		return id2;
	}

	public void setId2(Integer id2) {
		this.id2 = id2;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Apply getModel() {
		return model;
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	private Map<String, Object> session = null;

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;

	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
