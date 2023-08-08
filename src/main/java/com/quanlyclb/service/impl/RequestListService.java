package com.quanlyclb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.quanlyclb.dao.IRequestListDao;
import com.quanlyclb.model.RequestListModel;
import com.quanlyclb.paging.Pageble;

public class RequestListService implements IRequestListService{

	@Inject
	private IRequestListDao requestListDao; 
	
	@Override
	public List<RequestListModel> findAll() {
		return requestListDao.findAll();
	}

	@Override
	public List<RequestListModel> findAll(Pageble pageble) {
		return requestListDao.findAll(pageble);
	}

	@Override
	public RequestListModel findOne(long requestID) {
		return requestListDao.findOne(requestID);
	}

	@Override
	public RequestListModel save(RequestListModel requestModel) {
		requestModel.setRequestTime(new Timestamp(System.currentTimeMillis()));
		Long rq = requestListDao.save(requestModel);
		return requestListDao.findOne(rq);
	}

	@Override
	public RequestListModel accept(RequestListModel acceptRequest) {
		requestListDao.accept(acceptRequest);
		return requestListDao.findOne(acceptRequest.getRequestID());
	}

	@Override
	public RequestListModel finish(RequestListModel finishRequest) {
		requestListDao.finish(finishRequest);
		return requestListDao.findOne(finishRequest.getRequestID());
	}

	@Override
	public void delete(long requestID) {
		requestListDao.delete(requestID);
	}

	@Override
	public int getTotalItem() {
		return requestListDao.getTotalItem();
	}

}