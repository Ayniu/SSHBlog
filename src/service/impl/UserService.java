package service.impl;

import dao.IUserDAO;
import entity.User;
import service.IUserService;

public class UserService implements IUserService {

	private IUserDAO userDAO;
	
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean createUser(User user) {
		return this.userDAO.createUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return this.userDAO.updateUser(user);
	}

	@Override
	public User[] getAllUsers() {
		return this.userDAO.getAllUsers();
	}

	@Override
	public User getUserById(int userid) {
		return this.userDAO.getUserByUserid(userid);
	}

	@Override
	public User deleteUserById(int userid) {
		return this.userDAO.deleteUserById(userid);
	}

	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return this.userDAO.checkUser(user);
	}

	@Override
	public Object searchUsers(String usernames) {
		// TODO Auto-generated method stub
		return this.userDAO.searchUsers(usernames);
	}

}
