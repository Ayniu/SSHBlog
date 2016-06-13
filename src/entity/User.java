package entity;

import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userid;
	private String password;
	private String username;
	private Integer gender;// 0,1,2分别为男，女，保密
	private Integer age;
	private Integer type;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(Integer userid, String password, String username,
			Integer gender, Integer age, Integer type) {
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.gender = gender;
		this.age = age;
		this.type = type;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	// 使用注解设置默认值
	// @Column(name = "type", nullable=false, columnDefinition =
	// "INT default 0")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


	public String toString() {
		return "userid: " + userid + ", username: " + username;
	}

}