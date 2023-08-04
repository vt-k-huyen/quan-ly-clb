package com.quanlyclb.model;

import java.sql.Timestamp;

public class MessageModel extends AbstractModel<MessageModel>{
	private Long messageID;
	private String title;
	private String content;
	private String memberID;
	private Timestamp sendTime;
	private Timestamp receiveTime;
	private String memberSend;
	public String getMemberSend() {
		return memberSend;
	}
	public void setMemberSend(String memberSend) {
		this.memberSend = memberSend;
	}
	public Long getMessageID() {
		return messageID;
	}
	public void setMessageID(Long messangeID) {
		this.messageID = messangeID;
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
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	public Timestamp getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Timestamp receiveTime) {
		this.receiveTime = receiveTime;
	}
	public MessageModel(Long messageID, String title, String content, String memberID, Timestamp sendTime,
			Timestamp receiveTime, String memberSend) {
		super();
		this.messageID = messageID;
		this.title = title;
		this.content = content;
		this.memberID = memberID;
		this.sendTime = sendTime;
		this.receiveTime = receiveTime;
		this.memberSend = memberSend;
	}
	public MessageModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
