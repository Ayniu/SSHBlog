package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.BaseDAO;
import dao.IWeiboDAO;
import entity.User;
import entity.Weibo;

public class WeiboDAO extends BaseDAO implements IWeiboDAO {

	private Transaction tx = null;
	private String hql = "";
	private Session session;

	@Override
	public boolean publishWeibo(Weibo weibo, User user) {
		// TODO Auto-generated method stub
		try {
			session = getSession();
			tx = session.beginTransaction();
			weibo.setUser(user);
			session.save(weibo);
			System.out.println("发布成功～");
			// 事务要在返回之前commit
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("publish error!");
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public Weibo[] getWeibosByUser(User user) {
		// TODO Auto-generated method stub
		try {
			session = getSession();
			// 开始事务
			Transaction tx = session.beginTransaction();
			Integer userid = user.getUserid();
			hql = "from Weibo w where w.user=" + userid;
			Query query = session.createQuery(hql);
			List<Weibo> list = query.list();
			int listSize = list.size();
			// 判断是否查到
			if (listSize > 0) {
				System.out.println("查到weibo：");
				Weibo[] weibos = new Weibo[listSize];
				for (int i = 0; i < listSize; i++) {
					weibos[i] = list.get(i);
					System.out.println("(" + weibos[i].getText() + ")");
				}
				// 事务要在返回之前commit
				tx.commit();
				session.close();
				return weibos;
			} else {
				System.out.println("暂无weibo！");
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
	public Weibo deleteWeiboById(int weiboid) {
		// TODO Auto-generated method stub
		try {
			session = getSession();
			// 开始事务
			tx = session.beginTransaction();
			Weibo weibo = (Weibo) session.get(Weibo.class, weiboid);
			session.delete(weibo);
			System.out.println("删除weibo：(" + weibo.getWeiboid() + ") 成功");
			// 事务要在返回之前commit
			tx.commit();
			session.close();
			return weibo;
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
	public int getMaxUserid() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Weibo[] getWeibosByUserid(int userid) {
		// TODO Auto-generated method stub
		try {
			session = getSession();
			// 开始事务
			Transaction tx = session.beginTransaction();
			hql = "from Weibo w where w.user=" + userid;
			Query query = session.createQuery(hql);
			List<Weibo> list = query.list();
			int listSize = list.size();
			// 判断是否查到food
			if (listSize > 0) {
				System.out.println("查到weibo：");
				Weibo[] weibos = new Weibo[listSize];
				for (int i = 0; i < listSize; i++) {
					weibos[i] = list.get(i);
					System.out.println("(" + weibos[i].getText() + ")");
				}
				// 事务要在返回之前commit
				tx.commit();
				session.close();
				return weibos;
			} else {
				System.out.println("暂无weibo！");
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
