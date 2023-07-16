package com.quanlyclb.model;

import java.sql.Timestamp;

public class AnnouncementModel extends AbstractModel<AnnouncementModel>{
	private Long announcementID;
	private String title;
	private String content;
	private String photo;
	private String clubID;
	private Timestamp createDate;
	private String createBy;
	private String note;
	public Long getAnnouncementID() {
		return announcementID;
	}
	public void setAnnouncementID(Long announcementID) {
		this.announcementID = announcementID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getClubID() {
		return clubID;
	}
	public void setClubID(String clubID) {
		this.clubID = clubID;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
}
