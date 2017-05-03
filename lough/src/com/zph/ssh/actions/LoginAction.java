package com.zph.ssh.actions;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.wiscom.is.IdentityFactory;
import com.wiscom.is.IdentityManager;
import com.zph.ssh.service.AdminUserService;

public class LoginAction implements SessionAware {
	private String username;
	private String password;
	private String role;
	private String name;
	private AdminUserService adminUserService;

	public String login() {
		return "login";
	}

	public String log() throws Exception {
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request = ServletActionContext.getRequest();
		String is_config = request.getSession().getServletContext()
				.getRealPath("/WEB-INF/classes/client.properties");
		System.out.println("is_config" + is_config);

		Cookie all_cookies[] = request.getCookies();
		Cookie myCookie;
		String decodedCookieValue = null;

		if (all_cookies != null) {
			System.out.println("all_cookies.length" + all_cookies.length);
			for (int i = 0; i < all_cookies.length; i++) {
				myCookie = all_cookies[i];
				System.out.println(myCookie.getName().toString());
				if (myCookie.getName().equals("iPlanetDirectoryPro")) {
					System.out
							.println("myCookie.getName().equals('iPlanetDirectoryPro')");
					decodedCookieValue = URLDecoder.decode(myCookie.getValue(),
							"GB2312");
					System.out.println("1");
				}
			}
		}
		IdentityFactory factory = IdentityFactory.createFactory(is_config);
		IdentityManager im = factory.getIdentityManager();
		String curUser = "";
		System.out.println("decodedCookieValue" + decodedCookieValue);
		if (decodedCookieValue != null) {
			curUser = im.getCurrentUser(decodedCookieValue);
		}
		session.put("username", username);
		name = im.getUserNameByID(username);
		session.put("name", name);
		System.out.println("curuser" + curUser);
		if (im.checkPassword(username, password)) {
			name = im.getUserNameByID(username);
			System.out.println("role" + role);
			session.put("name", name);
			session.put("role", role);
			System.out.println(username + "-+++++++" + password);
			System.out.println(name + "-+++++++name");
			System.out.println(role + "-+++++++role");
			if (role != null && role.equals("2")
					&& (adminUserService.getAdminUser(username) != null)) {

				System.out.println("wo shi guanli");
				return "admin";
			} else {
				return "teacher";
			}

		} else {
			return "loginfalse";
		}

	}

	public String logout() {
		session.remove("username");
		System.out.println("logout");
		return "logout";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LoginAction [password=" + password + ", name=" + name + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public AdminUserService getAdminUserService() {
		return adminUserService;
	}

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}
