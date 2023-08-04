package com.quanlyclb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.quanlyclb.dao.IAnnouncementDao;
import com.quanlyclb.dao.IClubDao;
import com.quanlyclb.model.AnnouncementModel;
import com.quanlyclb.model.ClubModel;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IAnnouncementService;

public class AnnouncementService implements IAnnouncementService{

	@Inject
	private IAnnouncementDao announcementDao;
	
	@Inject
	private IClubDao clubDao;
	
	@Override
	public List<AnnouncementModel> findAll(Pageble pageble) {
		return announcementDao.findAll(pageble);
	}

	@Override
	public AnnouncementModel save(AnnouncementModel announcementModel) {
		announcementModel.setCreateDate(new Timestamp(System.currentTimeMillis()));
		
		  ClubModel club = clubDao.findOne(announcementModel.getClubID());
		  announcementModel.setClubID(club.getClubID());
		 
		Long a = announcementDao.save(announcementModel);
		return announcementDao.findOne(a);
	}

	@Override
	public AnnouncementModel update(AnnouncementModel updateAnnouncement) {
		AnnouncementModel old = announcementDao.findOne(updateAnnouncement.getAnnouncementID());
		updateAnnouncement.setCreateDate(old.getCreateDate());
		updateAnnouncement.setCreateBy(old.getCreateBy());
		
		  ClubModel club = clubDao.findOne(updateAnnouncement.getClubID());
		  updateAnnouncement.setClubID(club.getClubID());
		 
		announcementDao.update(updateAnnouncement);
		return announcementDao.findOne(updateAnnouncement.getAnnouncementID());
	}

	@Override
	public void delete(long[] announcementID) {
		for(long a: announcementID) {
			announcementDao.delete(a);
		}		
	}

	@Override
	public List<AnnouncementModel> findByClubId(String clubID) {
		return announcementDao.findByClubId(clubID);
	}

	@Override
	public int getTotalItem() {
		return announcementDao.getTotalItem();
	}

	@Override
	public AnnouncementModel findOne(Long announcementID) {
		AnnouncementModel announcementModel = announcementDao.findOne(announcementID);
		ClubModel clubModel = clubDao.findOne(announcementModel.getClubID());
		announcementModel.setClubID(clubModel.getClubID());
		return announcementModel;
	}

	@Override
	public List<AnnouncementModel> findAll() {
		return announcementDao.findAll();
	}

}
