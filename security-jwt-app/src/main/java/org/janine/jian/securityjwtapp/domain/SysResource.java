package org.janine.jian.securityjwtapp.domain;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 描述：sys_resource模型
* @author tools
*/
@Table(name = "sys_resource")
@Entity
public class SysResource{
	
    /*
     * 角色ID
     */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "resource_id")
    private int resourId;
	/*
     * 资源类型
     */
	@Column(name = "resource_type")
    private int resourceType;
    /*
     * 资源名称
     */
	@Column(name = "resource_name")
    private String resourceName;
    /*
     * 资源路径
     */
	@Column(name = "resource_url")
    private String resourceUrl;
    /*
     * 资源操作
     */
	@Column(name = "resource_operation")
    private String resourceOperation;
    
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
	public int getResourId() {
		return resourId;
	}
	public void setResourId(int resourId) {
		this.resourId = resourId;
	}
	public int getResourceType() {
		return resourceType;
	}
	public void setResourceType(int resourceType) {
		this.resourceType = resourceType;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceUrl() {
		return resourceUrl;
	}
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	public String getResourceOperation() {
		return resourceOperation;
	}
	public void setResourceOperation(String resourceOperation) {
		this.resourceOperation = resourceOperation;
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
    
}