package com.quanlyclb.dao.impl;

import java.util.List;

import com.quanlyclb.dao.IRequestListDao;
import com.quanlyclb.mapper.RequestListMapper;
import com.quanlyclb.model.RequestListModel;
import com.quanlyclb.paging.Pageble;

public class RequestListDao extends AbstractDao<RequestListModel> implements IRequestListDao{

	@Override
	public List<RequestListModel> findAll() {
		String sql = "SELECT * FROM requests_list";
		return query(sql, new RequestListMapper());
	}

	@Override
	public List<RequestListModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM requests_list");
		if(pageble.getSorter() != null ) {
			sql.append(" ORDER BY "+ pageble.getSorter().getSortName() +" " + pageble.getSorter().getSortBy() + "");
		}	
		if( pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() +"");
		} 
		return query(sql.toString(), new RequestListMapper());
	}

	@Override
	public RequestListModel findOne(long requestID) {
		String sql = "SELECT * FROM requests_list WHERE request_id = ?";
		List<RequestListModel> rq = query(sql,new RequestListMapper(), requestID);
		return rq.isEmpty() ? null : rq.get(0);
	}

	@Override
	public long save(RequestListModel requestModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO requests_list(member_id, club_id, request_time, status)");
		sql.append(" VALUES(?,?,?,0)");
		return insert(sql.toString(), requestModel.getMemberID(), requestModel.getClubID(), requestModel.getRequestTime());
	}


	@Override
	public void delete(long requestID) {
		String sql = "DELETE FROM requests_list WHERE request_id = ?";
		update(sql, requestID);
	}

	@Override
	public int getTotalItem() {
		String sql  = "SELECT count(*) FROM requests_list";
		return count(sql);
	}

	@Override
	public void accept(RequestListModel acceptRequest) {
		String sql = "UPDATE requests_list SET accept_time = ?, status = 1 WHERE request_id = ?";
		update(sql, acceptRequest.getAcceptTime(),acceptRequest.getRequestID());
	}

	@Override
	public void finish(RequestListModel finishRequest) {
		String sql = "UPDATE requests_list SET finish_time = ?, status = 2 WHERE request_id = ?";
		update(sql, finishRequest.getFinishTime(), finishRequest.getRequestID());
	}

	@Override
	public List<RequestListModel> findClubs(String memberID, Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM requests_list WHERE member_id LIKE ?");
		if(pageble.getSorter() != null ) {
			sql.append(" ORDER BY "+ pageble.getSorter().getSortName() +" " + pageble.getSorter().getSortBy() + "");
		}	
		if( pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() +"");
		} 
		return query(sql.toString(), new RequestListMapper(),memberID);
	}


}
