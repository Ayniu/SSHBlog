package service;

import entity.Attention;
import entity.User;

public interface IAttentionService {
	public boolean addAttention(Attention attention);
	public boolean removeAttention(Attention attention);
	public User[] getAttentions(User user);
	
	public User[] getFollowers(User user);
}
