package com.quanlyclb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.quanlyclb.model.MemberModel;

public class MemberMapper implements RowMapper<MemberModel>{

	@Override
	public MemberModel mapRow(ResultSet rs) {
		MemberModel m = new MemberModel();
		try {
			m.setMemberID(rs.getString("member_id"));
			m.setFirstName(rs.getString("first_name"));
			m.setLastName(rs.getString("last_name"));
			m.setBirtDate(rs.getDate("birth_date"));
			m.setEmail(rs.getString("email"));
			m.setAddress(rs.getString("address"));
			m.setPhoto(rs.getString("photo"));
			m.setPhoneNumber(rs.getString("phone_number"));
			m.setNotes(rs.getString("notes"));
			return m;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
