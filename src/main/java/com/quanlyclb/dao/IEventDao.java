package com.quanlyclb.dao;

import java.util.List;

import com.quanlyclb.model.EventModel;
import com.quanlyclb.paging.Pageble;

public interface IEventDao extends GenericDao<EventModel>{
	List<EventModel> findAll();
	List<EventModel> findAll(Pageble pageble);
	List<EventModel> findEvents(String memberID, Pageble pageble);
	EventModel findOne(long eventID);
	Long save(EventModel eventModel);
	void update(EventModel updateEvent);
	void delete(long eventID);
	int getTotalItem();
}
