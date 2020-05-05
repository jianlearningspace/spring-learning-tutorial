package org.shadow.simplecurd.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 中间表（用户-爱好）
 * @author jian
 *
 */
@Table(name = "user_hobby")
@Entity
public class UserHobby {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_hobby_id")
	private long userHobbyId;
	
	@Column(name = "user_id", insertable=false, updatable=false)
	private long userid;
	
	@Column(name = "hobby_id", insertable=false, updatable=false)
	private long hobbyid;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Hobby.class)
	@JoinColumn(name = "hobby_id", referencedColumnName = "hobby_id")
	private Hobby hobby;

	public long getUserHobbyId() {
		return userHobbyId;
	}

	public void setUserHobbyId(long userHobbyId) {
		this.userHobbyId = userHobbyId;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getHobbyid() {
		return hobbyid;
	}

	public void setHobbyid(long hobbyid) {
		this.hobbyid = hobbyid;
	}
	
	

}
