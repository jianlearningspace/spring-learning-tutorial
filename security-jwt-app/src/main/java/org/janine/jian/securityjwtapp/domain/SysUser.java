package org.janine.jian.securityjwtapp.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
* 描述：sys_user模型
* @author tools
*/
@Table(name = "sys_user")
@Entity
public class SysUser{
	
    /*
     * 用户ID
     */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
    private int userId;
    /*
     * 用户登陆名
     */
	@Column(name = "username")
    private String username;
    /*
     * 用户登陆密码
     */
	@Column(name = "password")
    private String password;
    /*
     * 所属部门ID
     */
	@Column(name = "department_id")
    private int departmentId;
    /*
     * 职位ID
     */
	@Column(name = "post_id")
    private int postId;
    /*
     * 最后登陆时间
     */
	@Column(name = "last_login")
    private Date lastLogin;
    /*
     * 记录创建时间
     */
	@Column(name = "create_date")
    private Timestamp createDate;
    /*
     * 排序号
     */
	@Column(name = "order_by")
    private int orderBy;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = SysUserRole.class)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private Set<SysUserRole> roles;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public int getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}
	public Set<SysUserRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<SysUserRole> roles) {
		this.roles = roles;
	}
}