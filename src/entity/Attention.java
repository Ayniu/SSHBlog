package entity;

import java.lang.reflect.Field;

import javax.persistence.Column;

public class Attention {
	private Integer attentionid;
	private Integer useridA;
	private Integer useridB;
//	private User userA;
//	private User userB;
	private Integer relation; // 0, 1, 2, 3分别为: AB不相互关注，A关注B，B关注A，AB相互关注

	public String toString() {
		String string="";
		try {
			Class clazz = Class.forName("entity.Attention");// 根据类名获得其对应的Class对象 写上你想要的类名就是了
											// 注意是全名 如果有包的话要加上
											// 比如java.Lang.String
			Field[] fields = clazz.getDeclaredFields();// 根据Class对象获得属性 私有的也可以获得
			int i = 0;
			for (Field f : fields) {
//				System.out.println(f.getType().getName()+": "+fields[i].get(this));// 打印每个属性的类型名字
				string += f.getType().getName()+": "+fields[i].get(this)+";\n";
				i+=1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return string;
	}

	public Integer getAttentionid() {
		return attentionid;
	}

	public void setAttentionid(Integer attentionid) {
		this.attentionid = attentionid;
	}


	public Integer getUseridA() {
		return useridA;
	}

	public void setUseridA(Integer useridA) {
		this.useridA = useridA;
	}

	public Integer getUseridB() {
		return useridB;
	}

	public void setUseridB(Integer useridB) {
		this.useridB = useridB;
	}
	
	

	@Column(name = "relation", nullable = false, columnDefinition = "INT default 1")
	public Integer getRelation() {
		return relation;
	}

//	public User getUserA() {
//		return userA;
//	}
//
//	public void setUserA(User userA) {
//		this.userA = userA;
//	}
//
//	public User getUserB() {
//		return userB;
//	}
//
//	public void setUserB(User userB) {
//		this.userB = userB;
//	}

	public void setRelation(Integer relation) {
		this.relation = relation;
	}

}
