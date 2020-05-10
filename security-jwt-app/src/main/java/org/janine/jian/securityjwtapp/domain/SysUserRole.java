package org.janine.jian.securityjwtapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
* 描述：sys_user_role模型
* @author tools
*/
@Table(name = "sys_user_role")
@Entity
public class SysUserRole{
	
    /*
     * 用户-角色关联ID
     */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_role_id")
    private int userRoleId;
    /*
     * 用户ID
     */
	@Column(name = "user_id", insertable=false, updatable=false)
    private int userId;
    /*
     * 角色ID
     */
	@Column(name = "role_id", insertable=false, updatable=false)
    private int roleId;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@JsonIgnore
	private SysUser user;
	
	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	@JsonIgnore
	private SysRole role;
	
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public SysUser getUser() {
		return user;
	}
	public void setUser(SysUser user) {
		this.user = user;
	}
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
}