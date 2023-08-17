package com.quanlyclb.dao.impl;

import java.util.List;

import com.quanlyclb.dao.IMemberDao;
import com.quanlyclb.mapper.ClubMapper;
import com.quanlyclb.mapper.MemberMapper;
import com.quanlyclb.model.MemberModel;
import com.quanlyclb.paging.Pageble;

public class MemberDao extends AbstractDao<MemberModel> implements IMemberDao{

	@Override
	public List<MemberModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM members");
		if(pageble.getSorter() != null ) {
			sql.append(" ORDER BY "+ pageble.getSorter().getSortName() +" " + pageble.getSorter().getSortBy() + "");
		}	
		if( pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() +"");
		} 
		return query(sql.toString(), new MemberMapper());
	}
	@Override
	public List<MemberModel> findAll() {
		String sql = "SELECT * FROM members";
		return query(sql, new MemberMapper());
	}

	@Override
	public MemberModel findOne(String memberID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(MemberModel memberModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO members(member_id, first_name, last_name, birth_date, email, address, photo, phone_number, notes)");
		sql.append(" VALUES(?,?,?,?,?,?,?,?.?)");
		insertByID(sql.toString(), memberModel.getMemberID(), memberModel.getFirstName(), memberModel.getLastName(), memberModel.getBirtDate(),
				memberModel.getEmail(), memberModel.getAddress(), memberModel.getPhoto(), memberModel.getPhoneNumber(), memberModel.getNotes());
	}

	@Override
	public void update(MemberModel updateMember) {
		StringBuilder sql = new StringBuilder("UPDATE members SET first_name = ?, last_name = ?, birth_date = ?, email = ?, address = ?, photo = ?,phone_number = ?,notes = ?");
		sql.append(" WHERE member_id = ?");
		update(sql.toString(), updateMember.getFirstName(), updateMember.getLastName(), updateMember.getBirtDate(), updateMember.getEmail(), updateMember.getAddress(),
				updateMember.getPhoto(), updateMember.getPhoneNumber(), updateMember.getNotes());
		
	}

	@Override
	public void delete(String memberID) {
		String sql = "DELETE FROM members WHERE member_id = ?";
		update(sql, memberID);	
	}

	@Override
	public int getTotalItem() {
		String sql  = "SELECT count(*) FROM members";
		return count(sql);
	}



}
