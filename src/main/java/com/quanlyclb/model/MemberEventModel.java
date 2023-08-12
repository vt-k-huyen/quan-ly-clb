package com.quanlyclb.model;

public class MemberEventModel extends AbstractModel<MemberEventModel>{
	private Long id;
	private Long eventID;
	private String memberID;
	private int status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEventID() {
		return eventID;
	}
	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public MemberEventModel(Long id, Long eventID, String memberID, int status) {
		super();
		this.id = id;
		this.eventID = eventID;
		this.memberID = memberID;
		this.status = status;
	}
	public MemberEventModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
