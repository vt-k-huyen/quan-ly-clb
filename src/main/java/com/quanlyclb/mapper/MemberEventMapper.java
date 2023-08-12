package com.quanlyclb.mapper;

import java.sql.ResultSet;

import com.quanlyclb.model.MemberEventModel;

public class MemberEventMapper implements RowMapper<MemberEventModel>{

	@Override
	public MemberEventModel mapRow(ResultSet rs) {
		try {
			MemberEventModel me = new MemberEventModel();
			me.setMemberID(rs.getString("member_id"));
			me.setEventID(rs.getLong("event_id"));
			me.setId(rs.getLong("id"));
			me.setStatus(rs.getInt("status"));
			return me;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
