package com.quanlyclb.dao;

import java.util.List;

import com.quanlyclb.model.MemberModel;
import com.quanlyclb.paging.Pageble;

public interface IMemberDao extends GenericDao<MemberModel>{
	List<MemberModel> findAll(Pageble pageble);
	List<MemberModel> findAll();
	MemberModel findOne(String memberID);
	void save(MemberModel memberModel);
	void update(MemberModel updateMember);
	void delete(String memberID);
	int getTotalItem();
}
