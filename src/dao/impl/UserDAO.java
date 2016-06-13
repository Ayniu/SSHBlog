package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.BaseDAO;
import dao.IUserDAO;
import entity.User;

public class UserDAO extends BaseDAO implements IUserDAO {

	private Transaction tx = null;
	private String hql = "";
	private Session session;
	
	@Override
	public boolean createUser(User user) {
		try {
			// 开始事务
			session = getSession();
			tx = session.beginTransaction();
			session.save(user);
			System.out.println("新增User：" + user.getUsername() + "成功! 编号："
					+ user.getUserid());
			// 事务要在返回之前commit
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			// 如果事务没有提交
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public User getUserByUserid(int userid) {
		try {
			session = getSession();
			// 开始事务
			tx = session.beginTransaction();
			hql = "from User where userid=" + userid;
			User user = (User) session.createQuery(hql).uniqueResult();
			// 判断是否查到food
			if (user != null) {
				System.out.println("查到User：(" + user.getUserid() + ") "
						+ user.getUsername());
				tx.commit();
				session.close();
				return user;
			} else {
				System.out.println("查不到该User！");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean updateUser(User user) {
		try {
			session = getSession();
			// 开始事务
			tx = session.beginTransaction();
			System.out.println(user.getUserid() + "为"
					+ user.getGender() + "\n");
			session.update(user);
			System.out.println("修改User Name：" + "为"
					+ user.getUsername() + "成功");
			// 事务要在返回之前commit
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public User deleteUserById(int userid) {
		try {
			session = getSession();
			// 开始事务
			tx = session.beginTransaction();
			User user = (User) session.get(User.class, userid);
			session.delete(user);
			System.out.println("删除User：(" + user.getUserid() + ") "
					+ user.getUsername() + "成功");
			// 事务要在返回之前commit
			tx.commit();
			session.close();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	public int getMaxUserid() {
		try {
			session = getSession();
			// 开始事务
			tx = session.beginTransaction();
			// f为别名
			hql = "select max(t.userid) from User t";
			Integer maxFid = (Integer) session.createQuery(hql).uniqueResult();
			// 事务要在返回之前commit
			tx.commit();
			session.close();
			return maxFid;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	public User[] getAllUsers() {
		try {
			session = getSession();
			// 开始事务
			Transaction tx = session.beginTransaction();
			hql = "from User u where u.type=0";
			Query query = session.createQuery(hql);
			List list = query.list();
			int listSize = list.size();
			// 判断是否查到food
			if (listSize > 0) {
				System.out.println("查到user：");
				User[] users = new User[listSize];
				for (int i = 0; i < listSize; i++) {
					users[i] = (User) list.get(i);
					System.out.println("(" + users[i].getUserid() + ") "
							+ users[i].getUsername());
				}
				// 事务要在返回之前commit
				tx.commit();
				session.close();
				return users;
			} else {
				System.out.println("暂无User！");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public User checkUser(User user) {
		try {
			session = getSession();
			// 开始事务
			tx = session.beginTransaction();
			String username = user.getUsername();
			String password = user.getPassword();
			int type = user.getType();
			hql = "from User u where u.username=? and u.password=? and u.type=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, username);
			query.setParameter(1, password);
			query.setParameter(2, type);
			List list = query.list();
			int listSize = list.size();
			// 判断是否查到
			if (listSize != 0) {
				System.out.println("帐号密码正确！");
				// 事务要在返回之前commit
				tx.commit();
				session.close();
				return (User)list.get(0);
			} else {
				System.out.println("帐号密码错误！");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public User[] searchUsers(String usernames) {
		// TODO Auto-generated method stub
		// condition: 
		try {
			session = getSession();
			// 开始事务
			tx = session.beginTransaction();
			hql = "from User u where u.username like '%" + usernames +"%'";
			Query query = session.createQuery(hql);
			List list = query.list();
			int listSize = list.size();
			// 判断是否查到food
			if (listSize > 0) {
				User[] users = new User[listSize];
				for (int i = 0; i < listSize; i++) {
					users[i] = (User) list.get(i);
					System.out.println("(" + users[i].getUserid() + ") "
							+ users[i].getUsername());
				}
				// 事务要在返回之前commit
				tx.commit();
				session.close();
				return users;
			} else {
				System.out.println("暂无User！");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

}
