package com.quanlyclb.mapper;

import java.sql.ResultSet;

import com.quanlyclb.model.RequestListModel;

public class RequestListMapper implements RowMapper<RequestListModel>{

	@Override
	public RequestListModel mapRow(ResultSet rs) {
		try {
			RequestListModel rq = new RequestListModel();
			rq.setRequestID(rs.getLong("request_id"));
			rq.setMemberID(rs.getString("member_id"));
			rq.setClubID(rs.getString("club_id"));
			rq.setRequestTime(rs.getTimestamp("request_time"));
			rq.setAcceptTime(rs.getTimestamp("accept_time"));
			rq.setFinishTime(rs.getTimestamp("finish_time"));
			rq.setStatus(rs.getInt("status"));
			return rq;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
