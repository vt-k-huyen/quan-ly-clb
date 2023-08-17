package com.quanlyclb.service;

import java.util.List;

import com.quanlyclb.model.UserModel;
import com.quanlyclb.paging.Pageble;

public interface IUserService {
	UserModel findByEmail_Password_Status(String email, String password, Integer status);
	List<UserModel> findAll();
	List<UserModel> findAll(Pageble pageble);
	UserModel findOne(String userID);
	UserModel save(UserModel userModel);
	UserModel update(UserModel updateUser);
	void delete(String userID);
	int getTotalItem();	
	void ChangePassword(String userID, String pass);
}
