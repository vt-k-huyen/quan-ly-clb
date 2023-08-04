package com.quanlyclb.dao.impl;

import java.util.List;

import com.quanlyclb.dao.IAnnouncementDao;
import com.quanlyclb.mapper.AnnouncementMapper;
import com.quanlyclb.model.AnnouncementModel;
import com.quanlyclb.paging.Pageble;

public class AnnouncementDao extends AbstractDao<AnnouncementModel> implements IAnnouncementDao{

	@Override
	public List<AnnouncementModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM announcements");
		if(pageble.getSorter() != null ) {
			sql.append(" ORDER BY "+ pageble.getSorter().getSortName() +" " + pageble.getSorter().getSortBy() + "");
		}	
		if( pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() +"");
		} 
		return query(sql.toString(), new AnnouncementMapper());
	}

	@Override
	public AnnouncementModel findOne(Long announcementID) {
		String sql = "SELECT * FROM announcements WHERE announcement_id = ?";
		List<AnnouncementModel> announcement = query(sql,new AnnouncementMapper(), announcementID);
		return announcement.isEmpty() ? null : announcement.get(0);
	}

	@Override
	public Long save(AnnouncementModel announcementModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO announcements(title, content, club_id, create_date, notes, create_by)");
		sql.append(" VALUES(?,?,?,?,?,?)");
		return insert(sql.toString(), announcementModel.getTitle(), announcementModel.getContent(), announcementModel.getClubID(),
				announcementModel.getCreateDate(),announcementModel.getNote(), announcementModel.getCreateBy());
	}

	@Override
	public void update(AnnouncementModel updateAnnouncement) {
		StringBuilder sql = new StringBuilder("UPDATE announcements SET title = ?, content = ?, club_id = ?, create_date = ?, notes = ?");
		sql.append(" WHERE announcement_id = ?");
		update(sql.toString(), updateAnnouncement.getTitle(), updateAnnouncement.getContent(),updateAnnouncement.getClubID(), 
				updateAnnouncement.getCreateDate(), updateAnnouncement.getNote(), updateAnnouncement.getAnnouncementID());
	}

	@Override
	public void delete(long announcementID) {
		String sql = "DELETE FROM announcements WHERE announcement_id = ?";
		update(sql, announcementID);
	}

	@Override
	public List<AnnouncementModel> findByClubId(String clubID) {
		String sql = "SELECT * FROM announcements WHERE club_id = ?";
		return query(sql,new AnnouncementMapper(), clubID);
	}

	@Override
	public int getTotalItem() {
		String sql  = "SELECT count(*) FROM announcements";
		return count(sql);
	}

	@Override
	public List<AnnouncementModel> findAll() {
		String sql = "SELECT * FROM announcements";
		return query(sql, new AnnouncementMapper());
	}

}
