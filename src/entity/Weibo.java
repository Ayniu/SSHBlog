package entity;

import java.util.Date;

import javax.persistence.Column;

public class Weibo {
	private Integer weiboid;
	private User user;
	private String text;
	private Date publishDate;

	/** default constructor */
	public Weibo() {
	}
	
	public Weibo(Integer weiboid, User user, String text, Date publishDate) {
		super();
		this.weiboid = weiboid;
		this.user = user;
		this.text = text;
		this.publishDate = publishDate;
	}

	public Integer getWeiboid() {
		return weiboid;
	}
	public void setWeiboid(Integer weiboid) {
		this.weiboid = weiboid;
	}
	public User getUser() {
		return user;
	}
	
//	@Column(name = "type", columnDefinition = "INT default 0")
	public void setUser(User user) {
		this.user = user;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}
