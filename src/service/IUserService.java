package service;

import entity.User;

public interface IUserService {
	public boolean createUser(User user);
	public User checkUser(User user);
	public User[] getAllUsers(); 
	public User getUserById(int tid);
	public User deleteUserById(int tid);
	public boolean updateUser(User user);
	public Object searchUsers(String usernames);
}
