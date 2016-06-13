package service;

import entity.User;
import entity.Weibo;

public interface IWeiboService {
	public boolean publishWeibo(Weibo weibo, User user);
	public Weibo[] getWeibosByUser(User user); 
	public Weibo[] getWeibosByUserid(int userid); 
	public Weibo[] getWeibosByUseridPaging(int userid, int currentPage, int pageSize); 
	public Weibo deleteWeiboById(int weiboid);
	public int getTotalByUserid(int userid);
}
