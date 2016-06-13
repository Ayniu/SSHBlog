package action;

import service.IUserService;

import com.opensymphony.xwork2.ModelDriven;

import entity.User;

// 模型驱动的方式传递数据
public class UserAction extends SuperAction implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	protected User user = new User();
	protected IUserService userService;

	// 新增用户，由service调用方法完成
	public String createUser() throws Exception {
		if (userService.createUser(user)) {
			session.setAttribute("curUser", user);
			return "success";
		} else {
			return "fail";
		}
	}

	public String checkLogin() throws Exception {
		User testUser = userService.checkUser(user);
		if (testUser != null) {
			session.setAttribute("curUser", testUser);
			return "success";
		} else {
			return "fail";
		}
	}

	public String logOut() throws Exception {
		session.removeAttribute("curUser");
		return "success";
	}

	// 编辑用户，由service调用方法完成
	public String updateUser() throws Exception {
		if (userService.updateUser(user)) {
			session.setAttribute("curUser", user);
			return "success";
		} else {
			return "fail";
		}
	}

	// 获取所有用户
	public String getAllUsers() throws Exception {
		User[] users = userService.getAllUsers();
		if (users != null) {
			session.setAttribute("users", users);
			return "success";
		} else {
			return "fail";
		}
	}


	// 获取指定id用户
	public String getUserById() throws Exception {
		int userid = Integer.parseInt(request.getParameter("userid"));
		User testUser = userService.getUserById(userid);
		if (testUser != null) {
			session.setAttribute("curUser", testUser);
			return "success";
		} else {
			return "fail";
		}
	}
	// 获取指定id用户
	public String searchUser() throws Exception {
		String usernames = user.getUsername();
		User[] testUsers = (User[]) userService.searchUsers(usernames);
		if (testUsers != null) {
			session.setAttribute("users", testUsers);
			return "success";
		} else {
			return "fail";
		}
	}

	// 删除指定用户
	public String deleteUserById() throws Exception {
		int userid = user.getUserid();
		if (userService.deleteUserById(userid) != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	@Override
	public User getModel() {
		return this.user;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
