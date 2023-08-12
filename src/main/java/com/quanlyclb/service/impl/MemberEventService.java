package com.quanlyclb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.quanlyclb.dao.IMemberEventDao;
import com.quanlyclb.model.MemberEventModel;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IMemberEventService;

public class MemberEventService implements IMemberEventService{

	@Inject
	private IMemberEventDao meDao;
	
	@Override
	public List<MemberEventModel> findAll() {
		return meDao.findAll();
	}

	@Override
	public List<MemberEventModel> findAll(Pageble pageble) {
		return meDao.findAll(pageble);
	}

	@Override
	public MemberEventModel findOne(long id) {
		return meDao.findOne(id);
	}

	@Override
	public MemberEventModel save(MemberEventModel meModel) {
		long m = meDao.save(meModel);
		return meDao.findOne(m);
	}

	@Override
	public MemberEventModel accept(MemberEventModel acceptME) {
		meDao.accept(acceptME);
		return meDao.findOne(acceptME.getId());
	}

	@Override
	public MemberEventModel reject(MemberEventModel rejectME) {
		meDao.reject(rejectME);
		return meDao.findOne(rejectME.getId());
	}

	@Override
	public void delete(long id) {
		meDao.delete(id);
	}

	@Override
	public int getTotalItem() {
		return meDao.getTotalItem();
	}

	

}
