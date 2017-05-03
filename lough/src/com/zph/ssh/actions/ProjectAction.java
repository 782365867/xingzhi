package com.zph.ssh.actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.zph.ssh.entities.Project;
import com.zph.ssh.service.ProjectService;

public class ProjectAction extends ActionSupport implements Preparable,
		ModelDriven<Project>, RequestAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProjectService projectService;
	private LoginAction loginAction;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String input() {
		return INPUT;
	}

	public String list() {
		request.put("projects", projectService.getAll());
		if (session.get("role") != null && session.get("role").equals("2")) {
			return "list-a";
		} else {
			return "list-t";
		}

	}

	public String save() {
		projectService.saveOrUpdate(model);
		return "save";
	}

	public void prepareSave() {
		model = new Project();
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public LoginAction getLoginAction() {
		return loginAction;
	}

	public void setLoginAction(LoginAction loginAction) {
		this.loginAction = loginAction;
	}

	private Map<String, Object> request;
	private Project model;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	@Override
	public Project getModel() {
		return model;
	}

	@Override
	public void prepare() throws Exception {

	}

	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}
