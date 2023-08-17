package com.quanlyclb.dao.impl;

import java.util.List;

import com.quanlyclb.dao.IMemberEventDao;
import com.quanlyclb.mapper.MemberEventMapper;
import com.quanlyclb.mapper.RequestListMapper;
import com.quanlyclb.model.MemberEventModel;
import com.quanlyclb.model.RequestListModel;
import com.quanlyclb.paging.Pageble;

public class MemberEventDao extends AbstractDao<MemberEventModel> implements IMemberEventDao{

	@Override
	public List<MemberEventModel> findAll() {
		String sql = "SELECT * FROM members_events";
		return query(sql, new MemberEventMapper());
	}

	@Override
	public List<MemberEventModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM members_events");
		if(pageble.getSorter() != null ) {
			sql.append(" ORDER BY "+ pageble.getSorter().getSortName() +" " + pageble.getSorter().getSortBy() + "");
		}	
		if( pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() +"");
		} 
		return query(sql.toString(), new MemberEventMapper());
	}

	@Override
	public MemberEventModel findOne(long id) {
		String sql = "SELECT * FROM members_events WHERE id = ? ";
		List<MemberEventModel> me = query(sql,new MemberEventMapper(), id);
		return me.isEmpty() ? null : me.get(0);
	}

	@Override
	public long save(MemberEventModel meModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO members_events(member_id, event_id, status)");
		sql.append(" VALUES(?,?,0)");
		return insert(sql.toString(), meModel.getMemberID(), meModel.getEventID());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM members_events WHERE id = ?";
		update(sql, id);
	}

	@Override
	public int getTotalItem() {
		String sql  = "SELECT count(*) FROM members_events";
		return count(sql);

	}

	@Override
	public void accept(MemberEventModel acceptME) {
		String sql = "UPDATE members_events SET status = 1 WHERE id = ?";
		update(sql, acceptME.getId());
		
	}

	@Override
	public void reject(MemberEventModel rejectME) {
		String sql = "UPDATE members_events SET status = 2 WHERE id = ?";
		update(sql, rejectME.getId());
	}

	@Override
	public List<MemberEventModel> findEvents(String memberID, Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM members_events  WHERE member_id LIKE ? ");
		if(pageble.getSorter() != null ) {
			sql.append(" ORDER BY "+ pageble.getSorter().getSortName() +" " + pageble.getSorter().getSortBy() + "");
		}	
		if( pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() +"");
		} 
		return query(sql.toString(), new MemberEventMapper(), memberID);
	}

}
