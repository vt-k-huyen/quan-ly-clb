package com.quanlyclb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.quanlyclb.dao.IMemberDao;
import com.quanlyclb.model.ClubModel;
import com.quanlyclb.model.MemberModel;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IMemberService;

public class MemberService implements IMemberService{

	@Inject
	private IMemberDao memberDao;
	
	@Override
	public List<MemberModel> findAll() {
		return memberDao.findAll();
	}

	@Override
	public List<MemberModel> findAll(Pageble pageble) {
		return memberDao.findAll(pageble);
	}

	@Override
	public MemberModel findOne(String memberID) {
		return memberDao.findOne(memberID);
	}

	@Override
	public MemberModel save(MemberModel memberModel) {
		String member = memberDao.save(memberModel); 
		return memberDao.findOne(member);
	}

	@Override
	public MemberModel update(MemberModel updateMember) {
		memberDao.update(updateMember);
		return memberDao.findOne(updateMember.getMemberID());
	}

	@Override
	public void delete(String memberID) {
		memberDao.delete(memberID);
	}

	@Override
	public int getTotalItem() {
		return memberDao.getTotalItem();
	}

}
