package service.impl;

import dao.IAttentionDAO;
import service.IAttentionService;
import entity.Attention;
import entity.User;

public class AttentionService implements IAttentionService {
	private IAttentionDAO attentionDAO;
	
	public IAttentionDAO getAttentionDAO() {
		return attentionDAO;
	}

	public void setAttentionDAO(IAttentionDAO attentionDAO) {
		this.attentionDAO = attentionDAO;
	}

	@Override
	public boolean addAttention(Attention attention) {
		// TODO Auto-generated method stub
		return attentionDAO.addAttention(attention);
	}

	@Override
	public boolean removeAttention(Attention attention) {
		// TODO Auto-generated method stub
		return attentionDAO.removeAttention(attention);
	}

	@Override
	public User[] getAttentions(User user) {
		// TODO Auto-generated method stub
		return attentionDAO.getAttentions(user);
	}

	@Override
	public User[] getFollowers(User user) {
		// TODO Auto-generated method stub
		return attentionDAO.getFollowers(user);
	}

}
