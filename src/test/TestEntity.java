package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

// 生成实体类对应的数据库表结构
@SuppressWarnings("deprecation")
public class TestEntity {

	@Test
	public void testSchemaExport(){
		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象 (4.3.0开始弃用了ServiceRegistryBuilder)
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).build();
		// 创建sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		// 创建session对象
		Session session = sessionFactory.getCurrentSession();
		// 创建SchemaExport对象
		SchemaExport export = new SchemaExport(config);
		
		export.create(true, true);
		
	}
}
