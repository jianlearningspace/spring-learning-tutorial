package org.janine.jian.securityjwtapp.domain;

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
* 描述：sys_role模型
* @author tools
*/
@Table(name = "sys_role")
@Entity
public class SysRole{
	
    /*
     * 角色ID
     */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
    private int roleId;
    /*
     * 角色名称
     */
	@Column(name = "role_name")
    private String roleName;
    /*
     * 角色类型
     */
	@Column(name = "role_type")
    private int roleType;
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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = SysPermission.class)
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private Set<SysPermission> permissions;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getRoleType() {
		return roleType;
	}
	public void setRoleType(int roleType) {
		this.roleType = roleType;
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
	public Set<SysPermission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<SysPermission> permissions) {
		this.permissions = permissions;
	}
}