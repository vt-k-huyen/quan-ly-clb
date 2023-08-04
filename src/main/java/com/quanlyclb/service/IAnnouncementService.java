package com.quanlyclb.service;

import java.util.List;

import com.quanlyclb.model.AnnouncementModel;
import com.quanlyclb.paging.Pageble;

public interface IAnnouncementService {
	List<AnnouncementModel> findAll(Pageble pgeble);
	AnnouncementModel findOne(Long announcementID);
	AnnouncementModel save(AnnouncementModel announcementModel);
	AnnouncementModel update(AnnouncementModel updateAnnouncement);
	void delete(long[] announcementID);
	List<AnnouncementModel> findByClubId(String clubID);
	int getTotalItem();	
	List<AnnouncementModel> findAll();
}
