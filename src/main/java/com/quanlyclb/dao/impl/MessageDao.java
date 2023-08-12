package com.quanlyclb.dao.impl;

import java.util.List;

import com.quanlyclb.dao.IMessageDao;
import com.quanlyclb.mapper.RowMapper;
import com.quanlyclb.model.MessageModel;
import com.quanlyclb.paging.Pageble;

public class MessageDao implements IMessageDao{

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertByID(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MessageModel> findAll(Pageble pageble) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageModel findOne(Long messageID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(MessageModel messageModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MessageModel updateMessage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long messageID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MessageModel> findByClubId(String messageID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertString(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		
	}
	

}
