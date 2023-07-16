package com.quanlyclb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.quanlyclb.model.ClubModel;

public class ClubMapper implements RowMapper<ClubModel>{

	@Override
	public ClubModel mapRow(ResultSet rs) {
		try {
			ClubModel c = new ClubModel();
			c.setClubID(rs.getString("club_id"));
			c.setClubName(rs.getString("club_name"));
			c.setDescription(rs.getString("description"));
			c.setCreateDate(rs.getTimestamp("create_date"));
			c.setDissolutionDate(rs.getTimestamp("dissolution_date"));
			return c;
		} catch (SQLException e) {
			return null;
		}
	}

}
