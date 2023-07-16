package com.quanlyclb.dao;

import java.util.List;


import com.quanlyclb.model.MessageModel;
import com.quanlyclb.paging.Pageble;

public interface IMessageDao extends GenericDao<MessageModel>{
	List<MessageModel> findAll(Pageble pageble);
	MessageModel findOne(Long messageID);
	Long save(MessageModel messageModel);
	void update(MessageModel updateMessage);
	void delete(long messageID);
	List<MessageModel> findByClubId(String messageID);
	int getTotalItem();
}
