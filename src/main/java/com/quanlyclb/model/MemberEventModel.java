package com.quanlyclb.model;

public class MemberEventModel extends AbstractModel<MemberEventModel>{
	private String eventID;
	private String memberID;
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	
}
