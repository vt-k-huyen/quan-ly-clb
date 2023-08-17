package com.quanlyclb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.quanlyclb.dao.IUserDao;
import com.quanlyclb.model.UserModel;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IUserService;

public class UserService implements IUserService{

	@Inject
	private IUserDao userDao; 
	@Override
	public UserModel findByEmail_Password_Status(String email, String password, Integer status) {
		return userDao.findByEmail_Password_Status(email, password, status);
	}
	@Override
	public List<UserModel> findAll() {
		return userDao.findAll();
	}
	@Override
	public List<UserModel> findAll(Pageble pageble) {
		return userDao.findAll(pageble);
	}
	@Override
	public UserModel findOne(String userID) {
		return userDao.findOne(userID);
	}
	@Override
	public UserModel save(UserModel userModel) {
		userModel.setCreateDate(new Timestamp(System.currentTimeMillis()));
		userDao.save(userModel);
		String userID = userModel.getUserID();
		return userDao.findOne(userID);
	}
	@Override
	public UserModel update(UserModel updateUser) {
		UserModel old = userDao.findOne(updateUser.getUserID());
		updateUser.setCreateDate(old.getCreateDate());
		updateUser.setModifyDate(new Timestamp(System.currentTimeMillis()));
		userDao.update(updateUser);
		return userDao.findOne(updateUser.getUserID());
	}
	@Override
	public void delete(String userID) {
		userDao.delete(userID);	
	}
	@Override
	public int getTotalItem() {
		return userDao.getTotalItem();
	}
	@Override
	public void ChangePassword(String userID, String pass) {
		userDao.ChangePassword(userID,pass);
	}

}
