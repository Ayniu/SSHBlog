package service.impl;

import dao.IWeiboDAO;
import dao.impl.WeiboDAO;
import entity.User;
import entity.Weibo;
import service.IWeiboService;

public class WeiboService implements IWeiboService{

	private IWeiboDAO weiboDAO = new WeiboDAO();
	
	public IWeiboDAO getWeiboDAO() {
		return weiboDAO;
	}

	public void setWeiboDAO(IWeiboDAO weiboDAO) {
		this.weiboDAO = weiboDAO;
	}

	@Override
	public boolean publishWeibo(Weibo weibo, User user) {
		// TODO Auto-generated method stub
		return weiboDAO.publishWeibo(weibo, user);
	}

	@Override
	public Weibo[] getWeibosByUser(User user) {
		// TODO Auto-generated method stub
		return weiboDAO.getWeibosByUser(user);
	}

	@Override
	public Weibo deleteWeiboById(int weiboid) {
		// TODO Auto-generated method stub
		return weiboDAO.deleteWeiboById(weiboid);
	}

	@Override
	public Weibo[] getWeibosByUserid(int userid) {
		// TODO Auto-generated method stub
		return weiboDAO.getWeibosByUserid(userid);
	}

	@Override
	public Weibo[] getWeibosByUseridPaging(int userid, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return weiboDAO.getWeibosByUseridPaging(userid, currentPage, pageSize);
	}

	@Override
	public int getTotalByUserid(int userid) {
		// TODO Auto-generated method stub
		return weiboDAO.getTotalByUserid(userid);
	}

}
