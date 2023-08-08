package com.quanlyclb.dao.impl;

import java.util.List;

import com.quanlyclb.dao.IUserDao;
import com.quanlyclb.mapper.UserMapper;
import com.quanlyclb.model.UserModel;
import com.quanlyclb.paging.Pageble;

public class UserDao extends AbstractDao<UserModel> implements IUserDao{

	@Override
	public UserModel findByEmail_Password_Status(String email, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user_account AS u ");
		sql.append(" INNER JOIN role_account AS r ON r.id = u.role_id");
		sql.append(" WHERE email = ? AND password = ? AND status = ?");
		List<UserModel> user = query(sql.toString(),new UserMapper(), email, password, status);
		return user.isEmpty() ? null : user.get(0);
	}

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM user_account";
		return query(sql, new UserMapper());
	}

	@Override
	public List<UserModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user_account LEFT JOIN role_account ON role_id");
		if(pageble.getSorter() != null ) {
			sql.append(" ORDER BY "+ pageble.getSorter().getSortName() +" " + pageble.getSorter().getSortBy() + "");
		}	
		if( pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() +"");
		} 
		return query(sql.toString(), new UserMapper());
	}

	@Override
	public UserModel findOne(String userID) {
		String sql = "SELECT * FROM user_account WHERE user_id = ?";
		List<UserModel> user = query(sql,new UserMapper(), userID);
		return user.isEmpty() ? null : user.get(0);
	}

	@Override
	public String save(UserModel userModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO user_account(user_id, user_name, email, password, role_id, create_date)");
		sql.append(" VALUES (?,?,?,?,?,?)");
		return insertByID(sql.toString(),userModel.getUserID(), userModel.getUserName(),
				userModel.getEmail(), userModel.getPassword(), userModel.getRoleID(),userModel.getCreateDate());
	}

	@Override
	public void update(UserModel updateUser) {
		StringBuilder sql = new StringBuilder("UPDATE user_account SET user_name = ?, role_id = ?, create_date = ?, modify_date = ?");
		sql.append(" WHERE user_id = ?");
		update(sql.toString(), updateUser.getUserName(), updateUser.getRoleID(), updateUser.getCreateDate(), updateUser.getModifyDate(),updateUser.getUserID());
	}

	@Override
	public void delete(String userID) {
		String sql = "DELETE FROM user_account WHERE user_id = ?";
		update(sql, userID);
	}

	@Override
	public int getTotalItem() {
		String sql  = "SELECT count(*) FROM user_account";
		return count(sql);
	}
	
}
