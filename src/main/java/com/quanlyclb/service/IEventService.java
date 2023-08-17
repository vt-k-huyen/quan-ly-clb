package com.quanlyclb.service;

import java.util.List;

import com.quanlyclb.model.EventModel;
import com.quanlyclb.paging.Pageble;

public interface IEventService {
	List<EventModel> findAll();
	List<EventModel> findAll(Pageble pageble);
	List<EventModel> findEvents(String memberID, Pageble pageble);
	EventModel findOne(long eventID);
	EventModel save(EventModel eventModel);
	EventModel update(EventModel updateEvent);
	void delete(long eventID);
	int getTotalItem();
	int count(String memberID, Pageble pageble);
}
