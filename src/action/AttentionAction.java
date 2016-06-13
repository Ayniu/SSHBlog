package action;

import service.IAttentionService;
import service.impl.AttentionService;

import com.opensymphony.xwork2.ModelDriven;

import entity.Attention;
import entity.User;

public class AttentionAction extends SuperAction implements ModelDriven<Attention> {
	
	private static final long serialVersionUID = 1L;
	protected Attention attention = new Attention();
	protected IAttentionService attentionService = new AttentionService();
	
	public String addAttention() throws Exception {
//		System.out.println(attention);
		if (attentionService.addAttention(attention)) {
			return "success";
		} else {
			return "fail";
		}
	}
	public String removeAttention() throws Exception {
		if (attentionService.removeAttention(attention)) {
			return "success";
		} else {
			return "fail";
		}
	}
	public String getAttentions() throws Exception {
		User user = (User) session.getAttribute("curUser");
		User[] users = attentionService.getAttentions(user);
		if (users != null) {
			session.setAttribute("attUsers", users);
			session.setAttribute("attNum", users.length);
			return "success";
		} else {
			return "fail";
		}
	}
	public String getFollowers() throws Exception {
		User user = (User) session.getAttribute("curUser");
		User[] users = attentionService.getFollowers(user);
		if (users != null) {
			session.setAttribute("folUsers", users);
			session.setAttribute("folNum", users.length);
			return "success";
		} else {
			return "fail";
		}
	}
	
	@Override
	public Attention getModel() {
		// TODO Auto-generated method stub
		return attention;
	}

	public IAttentionService getAttentionService() {
		return attentionService;
	}

	public void setAttentionService(IAttentionService attentionService) {
		this.attentionService = attentionService;
	}

	
}
