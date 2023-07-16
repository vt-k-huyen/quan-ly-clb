package com.quanlyclb.service;

import java.util.List;

import com.quanlyclb.model.MemberModel;
import com.quanlyclb.paging.Pageble;

public interface IMemberService {
	List<MemberModel> findAll();
	List<MemberModel> findAll(Pageble pageble);
	MemberModel findOne(String memberID);
	MemberModel save(MemberModel memberModel);
	MemberModel update(MemberModel updateMember);
	void delete(String memberID);
	int getTotalItem();	
}
