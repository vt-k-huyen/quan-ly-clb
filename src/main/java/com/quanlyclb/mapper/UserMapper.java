package com.quanlyclb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.quanlyclb.model.RoleModel;
import com.quanlyclb.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel a = new UserModel();
			a.setUserID(rs.getString("user_id"));
			a.setUserName(rs.getString("user_name"));
			a.setEmail(rs.getString("email"));
			a.setPassword(rs.getString("password"));
			a.setCreateDate(rs.getTimestamp("create_date"));
			a.setStatus(rs.getInt("status"));
			if(rs.getTimestamp("modify_date") != null) {
				a.setModifyDate(rs.getTimestamp("modify_date"));
			}
			a.setRoleID(rs.getString("role_id"));
			try {
				RoleModel role = new RoleModel();
				role.setRoleID(rs.getString("role_id"));
				role.setRoleName(rs.getString("role_name"));
				a.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return a;
		} catch (SQLException e) {
			return null;
		}
	}
}
