package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.BaseDAO;
import dao.IAttentionDAO;
import entity.Attention;
import entity.User;

public class AttentionDAO extends BaseDAO implements IAttentionDAO {
	private Transaction tx = null;
	private String hql = "";
	private Session session;

	@Override
	public boolean addAttention(Attention attention) {
		// TODO Auto-generated method stub
		try {
			session = getSession();
			tx = session.beginTransaction();
			// 如果已有关注关系，则修改
			String hql = "from Attention a where a.useridA="
					+ attention.getUseridB() + " and a.useridB="
					+ attention.getUseridA();
			Attention testAttention = (Attention) session.createQuery(hql)
					.uniqueResult();
			if (testAttention != null) {
				testAttention.setRelation(3);
				session.update(testAttention);
			} else {
				User userA = (User) session.get(User.class,
						attention.getUseridA());
				User userB = (User) session.get(User.class,
						attention.getUseridB());
				System.out.println(attention);
				session.save(attention);
			}
			System.out.println("关注" + attention.getUseridB() + "成功！");
			tx.commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean removeAttention(Attention attention) {
		// TODO Auto-generated method stub
		try {
			session = getSession();
			tx = session.beginTransaction();
			Integer relation = 0;
			Boolean attentionExist = true;
			// case 1: 1 --> 2, and 2 --> 1, but 2 followed 1 first, so in the
			// database, 2 is UserA and 1 is userB
			hql = "select a.relation from Attention a where a.useridA="
					+ attention.getUseridB() + " and a.useridB="
					+ attention.getUseridA();
			relation = (Integer) session.createQuery(hql).uniqueResult();
			if (relation != null) {
				attention.setRelation(1);
			} else {
				hql = "select a.relation from Attention a where a.useridA="
						+ attention.getUseridA() + " and a.useridB="
						+ attention.getUseridB();
				relation = (Integer) session.createQuery(hql).uniqueResult();
				if (relation == 1) {
					// 不再相互关注
					attentionExist = false;
				} else {
					// userB --> userA remains
					attention.setRelation(2);
				}
			}
			if (attentionExist) {
				session.save(attention);
			} else {
				// 不再相互关注
				session.delete(attention);
			}
			System.out.println("取消关注成功！");
			tx.commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public User[] getAttentions(User user) {
		// TODO Auto-generated method stub
		try {
			session = getSession();
			tx = session.beginTransaction();
			// part one: user is userA
			hql = "select a.useridB from Attention a where a.useridA="
					+ user.getUserid() + " and a.relation in (1,3)";
			Query query = session.createQuery(hql);
			List<User> attentions1 = query.list();
			// part two: user is userB
			hql = "select a.useridA from Attention a where a.useridB="
					+ user.getUserid() + " and a.relation in (2,3)";
			query = session.createQuery(hql);
			List<User> attentions2 = query.list();
			attentions1.addAll(attentions2);
			int listSize = attentions1.size();
			if (listSize != 0) {
				System.out.println("查到attentions：");
				User[] users = new User[listSize];
				for (int i = 0; i < listSize; i++) {
					users[i] = (User) session.get(User.class, attentions1.get(i));
					System.out.println("(" + users[i] + ")");
				}
				// 事务要在返回之前commit
				tx.commit();
				session.close();
				return users;
			} else {
				System.out.println("No attention yet! ");
				return null;
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public User[] getFollowers(User user) {
		// TODO Auto-generated method stub
		try {
			session = getSession();
			tx = session.beginTransaction();
			// part one: user is userA
			hql = "select a.useridB from Attention a where a.useridA="
					+ user.getUserid() + " and a.relation in (2,3)";
			Query query = session.createQuery(hql);
			List<User> attentions1 = query.list();
			// part two: user is userB
			hql = "select a.useridA from Attention a where a.useridB="
					+ user.getUserid() + " and a.relation in(1,3)";
			query = session.createQuery(hql);
			List<User> attentions2 = query.list();
			attentions1.addAll(attentions2);
			int listSize = attentions1.size();
			if (listSize != 0) {
				System.out.println("查到follower：");
				User[] users = new User[listSize];
				for (int i = 0; i < listSize; i++) {
					users[i] = (User) session.get(User.class, attentions1.get(i));
					System.out.println("(" + users[i] + ")");
				}
				// 事务要在返回之前commit
				tx.commit();
				session.close();
				return users;
			} else {
				System.out.println("No follower yet! ");
				return null;
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

}
