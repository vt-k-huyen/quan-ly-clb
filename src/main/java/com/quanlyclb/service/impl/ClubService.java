package com.quanlyclb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.quanlyclb.dao.IClubDao;
import com.quanlyclb.model.ClubModel;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IClubService;

public class ClubService implements IClubService{
	
	@Inject
	private IClubDao clubDao;
	
	@Override
	public List<ClubModel> findAll() {
		return clubDao.findAll();
	}

	@Override
	public ClubModel findOne(String clubID) {
		return clubDao.findOne(clubID);
	}

	@Override
	public List<ClubModel> findAll(Pageble pageble) {
		return clubDao.findAll(pageble);
	}

	@Override
	public ClubModel save(ClubModel clubModel) {
		clubModel.setCreateDate(new Timestamp(System.currentTimeMillis()));
		clubDao.save(clubModel); 
		String clubID = clubModel.getClubID();
		return clubDao.findOne(clubID);
	}

	@Override
	public ClubModel update(ClubModel updateClub) {
		ClubModel old = clubDao.findOne(updateClub.getClubID());
		updateClub.setCreateDate(old.getCreateDate());
		clubDao.update(updateClub);
		return clubDao.findOne(updateClub.getClubID());
	}

	@Override
	public void delete(String clubID) {
		clubDao.delete(clubID);
	}

	@Override
	public int getTotalItem() {
		return clubDao.getTotalItem();
	}

	@Override
	public List<ClubModel> findClubs(String memberID, Pageble pageble) {
		return clubDao.findClubs(memberID, pageble);
	}

	@Override
	public int count(String memberID, Pageble pageble) {
		List<ClubModel> list =  clubDao.findAll();
		return list.size();
	}

}
