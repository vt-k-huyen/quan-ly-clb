package com.quanlyclb.model;

import java.sql.Timestamp;

public class EventModel extends AbstractModel<EventModel>{
	private Long eventID;
	private String eventName;
	private Timestamp fromDate;
	private Timestamp toDate;
	private String detail;
	private String clubID;
	private String notes;
	public Long getEventID() {
		return eventID;
	}
	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Timestamp getFromDate() {
		return fromDate;
	}
	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}
	public Timestamp getToDate() {
		return toDate;
	}
	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getClubID() {
		return clubID;
	}
	public void setClubID(String clubID) {
		this.clubID = clubID;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public EventModel(Long eventID, String eventName, Timestamp fromDate, Timestamp toDate, String detail,
			String clubID, String notes) {
		super();
		this.eventID = eventID;
		this.eventName = eventName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.detail = detail;
		this.clubID = clubID;
		this.notes = notes;
	}
	public EventModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
