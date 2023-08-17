package com.quanlyclb.dao;

import java.util.List;

import com.quanlyclb.model.UserModel;
import com.quanlyclb.paging.Pageble;

public interface IUserDao extends GenericDao<UserModel>{
	UserModel findByEmail_Password_Status(String email, String password, Integer status);
	List<UserModel> findAll();
	List<UserModel> findAll(Pageble pageble);
	UserModel findOne(String userID);
	void save(UserModel userModel);
	void update(UserModel updateUser);
	void delete(String userID);
	int getTotalItem();
	void ChangePassword(String userID, String pass);
}
