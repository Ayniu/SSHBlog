package dao;

import entity.User;

// 业务逻辑接口
public interface IUserDAO {

	// crud
	public boolean createUser(User user);
	public User getUserByUserid(int userid);
	public User[] getAllUsers();
	public User deleteUserById(int userid);
	public int getMaxUserid();
	public User checkUser(User user);
	public boolean updateUser(User user);
	
	// 管理员权限
	public User[] searchUsers(String usernames);
}
