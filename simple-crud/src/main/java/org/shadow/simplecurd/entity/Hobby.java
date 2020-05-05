package org.shadow.simplecurd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户爱好（many-to-many）
 * @author jian
 *
 */
@Table(name = "hobby")
@Entity
public class Hobby {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hobby_id")
	private long hobbyid;
	
	@Column(name = "hobby_name")
	private String hobbyName;
	
	public long getHobbyid() {
		return hobbyid;
	}
	public void setHobbyid(long hobbyid) {
		this.hobbyid = hobbyid;
	}
	public String getHobbyName() {
		return hobbyName;
	}
	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}
	

}
