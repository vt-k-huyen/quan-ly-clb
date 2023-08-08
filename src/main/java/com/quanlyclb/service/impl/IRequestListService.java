package com.quanlyclb.service.impl;

import java.util.List;

import com.quanlyclb.model.RequestListModel;
import com.quanlyclb.paging.Pageble;

public interface IRequestListService {
	List<RequestListModel> findAll();
	List<RequestListModel> findAll(Pageble pageble);
	RequestListModel findOne(long requestID);
	RequestListModel save(RequestListModel requestModel);
	RequestListModel accept(RequestListModel acceptRequest);
	RequestListModel finish(RequestListModel finishRequest);
	void delete(long requestID);
	int getTotalItem();
}
