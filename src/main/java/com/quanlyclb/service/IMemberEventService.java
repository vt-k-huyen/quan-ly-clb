package com.quanlyclb.service;

import java.util.List;

import com.quanlyclb.model.MemberEventModel;
import com.quanlyclb.paging.Pageble;

public interface IMemberEventService {
	List<MemberEventModel> findAll();
	List<MemberEventModel> findAll(Pageble pageble);
	MemberEventModel findOne(long id);
	MemberEventModel save(MemberEventModel meModel);
	MemberEventModel accept(MemberEventModel acceptME);
	MemberEventModel reject(MemberEventModel rejectME);
	void delete(long id);
	int getTotalItem();
}
