package com.quanlyclb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.quanlyclb.dao.IEventDao;
import com.quanlyclb.model.EventModel;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IEventService;

public class EventService implements IEventService {
	
	@Inject
 	private IEventDao eventDao;
	
	@Override
	public List<EventModel> findAll() {
		return eventDao.findAll();
	}

	@Override
	public List<EventModel> findAll(Pageble pageble) {
		return eventDao.findAll(pageble);
	}

	@Override
	public EventModel findOne(long eventID) {
		return eventDao.findOne(eventID);
	}

	@Override
	public EventModel save(EventModel eventModel) {
		Long e = eventDao.save(eventModel);
		return eventDao.findOne(e);
	}

	@Override
	public EventModel update(EventModel updateEvent) {
		eventDao.update(updateEvent);
		return eventDao.findOne(updateEvent.getEventID());
	}

	@Override
	public void delete(long eventID) {
		eventDao.delete(eventID);
	}

	@Override
	public int getTotalItem() {
		return eventDao.getTotalItem();
	}

	@Override
	public List<EventModel> findEvents(String memberID, Pageble pageble) {
		return eventDao.findEvents(memberID, pageble);
	}

	@Override
	public int count(String memberID, Pageble pageble) {
		List<EventModel> list = eventDao.findEvents(memberID, pageble);
		return list.size();
	}


}
