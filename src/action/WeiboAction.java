package action;

import java.util.Map;

import service.IWeiboService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import entity.Pager;
import entity.User;
import entity.Weibo;

// 模型驱动的方式传递数据
public class WeiboAction extends SuperAction implements ModelDriven<Weibo> {

	private static final long serialVersionUID = 1L;
	protected Weibo weibo = new Weibo();
	protected IWeiboService weiboService;

	// 发布微博，由service调用方法完成
	public String publishWeibo() throws Exception {
		User user = (User) session.getAttribute("curUser");
		if (weiboService.publishWeibo(weibo, user)) {
			System.out.println(weibo);
			session.setAttribute("weibo", weibo);
			return "success";
		} else {
			return "fail";
		}
	}

	// 获取所有微博
	public String getWeibosByUser() throws Exception {
		User user = (User) session.getAttribute("curUser");
		Weibo[] weibos = weiboService.getWeibosByUser(user);
		if (weibos != null) {
			session.setAttribute("weibos", weibos);
			session.setAttribute("owner", "1");
			return "success";
		} else {
			return "fail";
		}
	}
	
	// 获取指定id用户所有微博
	public String getWeibosByUserid() throws Exception {
		// 获取url参数 
		int userid = Integer.parseInt(request.getParameter("userid"));
		Weibo[] weibos = weiboService.getWeibosByUserid(userid);
		if (weibos != null) {
			session.setAttribute("weibos", weibos);
			session.setAttribute("owner", "0");
			return "success";
		} else {
			return "fail";
		}
	}
	
	// 获取指定id用户所有微博并翻页显示
	public String getWeibosByUseridPaging() throws Exception {
		// 获取url参数 
		int userid = Integer.parseInt(request.getParameter("userid"));
		int totalSize = weiboService.getTotalByUserid(userid);
		int currentPage = request.getParameter("currentPage")!=null ? Integer.parseInt(request.getParameter("currentPage")) : 1;
		Pager pager = new Pager(currentPage, totalSize);
		Weibo[] weibos = weiboService.getWeibosByUseridPaging(userid, currentPage, pager.getPageSize());
		Map request = (Map) ActionContext.getContext().get("request");
		if (weibos != null) {
			request.put("weibos", weibos);
			request.put("pager", pager);
			session.setAttribute("owner", "0");
			return "success";
		} else {
			return "fail";
		}
	}

	// 删除指定微博
	public String deleteWeiboById() throws Exception {
		int weiboid = weibo.getWeiboid();
		if (weiboService.deleteWeiboById(weiboid) != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	@Override
	public Weibo getModel() {
		return this.weibo;
	}

	public IWeiboService getWeiboService() {
		return weiboService;
	}

	public void setWeiboService(IWeiboService weiboService) {
		this.weiboService = weiboService;
	}

}
