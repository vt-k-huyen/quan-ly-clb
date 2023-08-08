package com.quanlyclb.dao;

import java.util.List;


import com.quanlyclb.model.RequestListModel;
import com.quanlyclb.paging.Pageble;

public interface IRequestListDao extends GenericDao<RequestListModel>{
	List<RequestListModel> findAll();
	List<RequestListModel> findAll(Pageble pageble);
	RequestListModel findOne(long requestID);
	long save(RequestListModel requestModel);
	void accept(RequestListModel acceptRequest);
	void finish(RequestListModel finishRequest);
	void delete(long requestID);
	int getTotalItem();
}
