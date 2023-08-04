package com.quanlyclb.model;

import java.sql.Timestamp;


public class UserModel extends AbstractModel<UserModel>{
	private String userID;
	private String userName;
	private String email;
	private String password;
	private String roleID;
	private RoleModel role = new RoleModel();
	private Integer status;
	private Timestamp createDate;
	private Timestamp modifyDate;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoleID() {
		return roleID;
	}
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public RoleModel getRole() {
		return role;
	}
	public void setRole(RoleModel role) {
		this.role = role;
	}
	public UserModel(String userID, String userName, String email, String password, String roleID, RoleModel role,
			Integer status, Timestamp createDate, Timestamp modifyDate) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.roleID = roleID;
		this.role = role;
		this.status = status;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
