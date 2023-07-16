package com.quanlyclb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.quanlyclb.model.AnnouncementModel;

public class AnnouncementMapper implements RowMapper<AnnouncementModel>{
	
	@Override
	public AnnouncementModel mapRow(ResultSet rs) {
		try {
			AnnouncementModel a = new AnnouncementModel();
			a.setAnnouncementID(rs.getLong("announcement_id"));
			a.setTitle(rs.getString("title"));
			a.setContent(rs.getString("content"));
			a.setPhoto(rs.getString("photo"));
			a.setClubID(rs.getString("club_id"));
			a.setCreateDate(rs.getTimestamp("create_date"));
			a.setCreateBy(rs.getString("create_by"));
			a.setNote(rs.getString("notes"));
			return a;
		} catch (SQLException e) {
			return null;
		}
	}
}
