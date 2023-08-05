package com.quanlyclb.dao.impl;

import java.util.List;

import com.quanlyclb.dao.IClubDao;
import com.quanlyclb.mapper.ClubMapper;
import com.quanlyclb.model.ClubModel;
import com.quanlyclb.paging.Pageble;

public class ClubDao extends AbstractDao<ClubModel> implements IClubDao{

	@Override
	public List<ClubModel> findAll() {
		String sql = "SELECT * FROM clubs";
		return query(sql, new ClubMapper());
	}

	@Override
	public ClubModel findOne(String clubID) {
		String sql = "SELECT * FROM clubs WHERE club_id = ?";
		List<ClubModel> club = query(sql,new ClubMapper(), clubID);
		return club.isEmpty() ? null : club.get(0);
	}

	@Override
	public List<ClubModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM clubs");
		if(pageble.getSorter() != null ) {
			sql.append(" ORDER BY "+ pageble.getSorter().getSortName() +" " + pageble.getSorter().getSortBy() + "");
		}	
		if( pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() +"");
		} 
		return query(sql.toString(), new ClubMapper());
	}

	@Override
	public String save(ClubModel clubModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO clubs(club_id, club_name, description, create_date, dissolution_date)");
		sql.append(" VALUES(?,?,?,?,?)");
		return insertByID(sql.toString(), clubModel.getClubID(), clubModel.getClubName(),clubModel.getDescription(), clubModel.getCreateDate(), clubModel.getDissolutionDate());
	}

	@Override
	public void update(ClubModel updateClub) {
		StringBuilder sql = new StringBuilder("UPDATE clubs SET club_name = ?, description = ?, create_date = ?, dissolution_date = ?");
		sql.append(" WHERE club_id LIKE ?");
		update(sql.toString(), updateClub.getClubName(), updateClub.getDescription(), updateClub.getCreateDate(), updateClub.getDissolutionDate(), updateClub.getClubID());
	}

	@Override
	public void delete(String clubID) {
		String sql = "DELETE FROM clubs WHERE club_id = ?";
		update(sql, clubID);
	}

	@Override
	public int getTotalItem() {
		String sql  = "SELECT count(*) FROM clubs";
		return count(sql);
	}

}
