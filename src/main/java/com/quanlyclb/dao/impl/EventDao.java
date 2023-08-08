package com.quanlyclb.dao.impl;

import java.util.List;

import com.quanlyclb.dao.IEventDao;
import com.quanlyclb.mapper.EventMapper;
import com.quanlyclb.model.EventModel;
import com.quanlyclb.paging.Pageble;

public class EventDao extends AbstractDao<EventModel> implements IEventDao{

	@Override
	public List<EventModel> findAll() {
		String sql = "SELECT * FROM events";
		return query(sql, new EventMapper());
	}

	@Override
	public List<EventModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM events");
		if(pageble.getSorter() != null ) {
			sql.append(" ORDER BY "+ pageble.getSorter().getSortName() +" " + pageble.getSorter().getSortBy() + "");
		}	
		if( pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() +"");
		} 
		return query(sql.toString(), new EventMapper());
	}

	@Override
	public EventModel findOne(long eventID) {
		String sql = "SELECT * FROM events WHERE event_id= ?";
		List<EventModel> event = query(sql,new EventMapper(), eventID);
		return event.isEmpty() ? null : event.get(0);
	}

	@Override
	public Long save(EventModel eventModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO events(event_name, detail, from_date, to_date, notes, club_id)");
		sql.append(" VALUES(?,?,?,?,?,?)");
		return insert(sql.toString(),eventModel.getEventName(), eventModel.getDetail(), eventModel.getFromDate(), eventModel.getToDate(),
				eventModel.getNotes(), eventModel.getClubID());
	}

	@Override
	public void update(EventModel updateEvent) {
		StringBuilder sql = new StringBuilder("UPDATE events SET event_name = ?, detail = ?, club_id = ?, from_date= ?, to_date= ?");
		sql.append(" WHERE event_id = ?");
		update(sql.toString(), updateEvent.getEventName(), updateEvent.getDetail(), updateEvent.getClubID(),
				updateEvent.getFromDate(), updateEvent.getToDate(), updateEvent.getEventID());
	}

	@Override
	public void delete(long eventID) {
		String sql = "DELETE FROM events WHERE event_id= ?";
		update(sql, eventID);
	}

	@Override
	public int getTotalItem() {
		String sql  = "SELECT count(*) FROM events";
		return count(sql);
	}
	
}
