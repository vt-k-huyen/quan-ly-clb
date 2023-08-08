package com.quanlyclb.mapper;

import java.sql.ResultSet;

import com.quanlyclb.model.EventModel;

public class EventMapper implements RowMapper<EventModel>{

	@Override
	public EventModel mapRow(ResultSet rs) {
		try {
			EventModel e = new EventModel();
			e.setEventID(rs.getLong("event_id"));
			e.setEventName(rs.getString("event_name"));
			e.setDetail(rs.getString("detail"));
			e.setFromDate(rs.getTimestamp("from_date"));
			e.setToDate(rs.getTimestamp("to_date"));
			e.setClubID(rs.getString("club_id"));
			e.setNotes(rs.getString("notes"));
			return e;
		} catch (Exception e) {
			return null;
		}
	}
}
