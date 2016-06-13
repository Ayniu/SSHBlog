package dao;

import entity.User;
import entity.Weibo;


// 业务逻辑接口
public interface IWeiboDAO {

	// crud
	public boolean publishWeibo(Weibo weibo, User user);
	public Weibo[] getWeibosByUser(User user);
	public Weibo[] getWeibosByUserid(int userid);
	public Weibo[] getWeibosByUseridPaging(int userid, int currentPage, int pageSize);
	public Weibo deleteWeiboById(int weiboid);
	public int getTotalByUserid(int userid);
	
}
