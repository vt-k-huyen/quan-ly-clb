package com.quanlyclb.model;

import java.sql.Timestamp;

public class RequestModel extends  AbstractModel<RequestModel>{
	private Long requestID;
	private String clubID;
	private String memberID;
	private Timestamp requestTime;
	private Timestamp acceptTime;
	private Timestamp finishTime;
	private int status;
	public Long getRequestID() {
		return requestID;
	}
	public void setRequestID(Long requestID) {
		this.requestID = requestID;
	}
	public String getClubID() {
		return clubID;
	}
	public void setClubID(String clubID) {
		this.clubID = clubID;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public Timestamp getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}
	public Timestamp getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(Timestamp acceptTime) {
		this.acceptTime = acceptTime;
	}
	public Timestamp getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public RequestModel(Long requestID, String clubID, String memberID, Timestamp requestTime, Timestamp acceptTime,
			Timestamp finishTime, int status) {
		super();
		this.requestID = requestID;
		this.clubID = clubID;
		this.memberID = memberID;
		this.requestTime = requestTime;
		this.acceptTime = acceptTime;
		this.finishTime = finishTime;
		this.status = status;
	}
	public RequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
