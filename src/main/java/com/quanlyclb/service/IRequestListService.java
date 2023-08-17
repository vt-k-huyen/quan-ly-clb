package com.quanlyclb.service;

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
	void deleteOne(long requestID);
	int getTotalItem();
	public List<RequestListModel> findClubs(String memberID,Pageble pageble);
	int count(String memberID, Pageble pageble);
}
