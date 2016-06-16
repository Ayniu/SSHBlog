package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		// hibernate初始化数据库连接，并设置autoCommit属性为false，即不自动提交事务。
		// 事务tx只有commit了之后，session的操作才会执行
		Session session = sessionFactory.openSession();
		return session;
	}
}
