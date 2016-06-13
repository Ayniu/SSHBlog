package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

// 工具类
public class MyHibernateSessionFactory {

	private static SessionFactory sessionFactory; // 会话工厂属性

	// 构造方法私有化，保证单例模式
	private MyHibernateSessionFactory() {

	}

	// 公有的属性方法，保存会话工厂对象
	public static SessionFactory getSessionFactory() {
		// 如果为空，则创建
		if (sessionFactory == null) {
			Configuration config = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(config.getProperties())
					.buildServiceRegistry();
			sessionFactory = config.buildSessionFactory();
			return sessionFactory;
		} else {
			return sessionFactory;
		}
	}
}
