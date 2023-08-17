package com.quanlyclb.dao;

import java.util.List;

import com.quanlyclb.model.MemberEventModel;
import com.quanlyclb.paging.Pageble;

public interface IMemberEventDao extends GenericDao<MemberEventModel>{
	List<MemberEventModel> findAll();
	List<MemberEventModel> findAll(Pageble pageble);
	List<MemberEventModel> findEvents(String memberID, Pageble pageble);
	MemberEventModel findOne(long id);
	long save(MemberEventModel meModel);
	void accept(MemberEventModel acceptME);
	void reject(MemberEventModel rejectME);
	void delete(long id);
	int getTotalItem();
}
