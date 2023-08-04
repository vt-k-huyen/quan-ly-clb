package com.quanlyclb.dao;

import java.util.List;

import com.quanlyclb.model.AnnouncementModel;
import com.quanlyclb.paging.Pageble;

public interface IAnnouncementDao extends GenericDao<AnnouncementModel> {
	List<AnnouncementModel> findAll(Pageble pageble);
	List<AnnouncementModel> findAll();
	AnnouncementModel findOne(Long announcementID);
	Long save(AnnouncementModel announcementModel);
	void update(AnnouncementModel updateAnnouncement);
	void delete(long announcementID);
	List<AnnouncementModel> findByClubId(String announcementID);
	int getTotalItem();
}
