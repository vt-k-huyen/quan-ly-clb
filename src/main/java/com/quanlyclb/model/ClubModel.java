package com.quanlyclb.model;

import java.sql.Timestamp;
import java.util.Date;

public class ClubModel extends AbstractModel<ClubModel>{
	private String clubID;
	private String clubName;
	private String description;
	private Timestamp createDate;
	private Timestamp dissolutionDate;
	public String getClubID() {
		return clubID;
	}
	public void setClubID(String clubID) {
		this.clubID = clubID;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getDissolutionDate() {
		return dissolutionDate;
	}
	public void setDissolutionDate(Timestamp dissolutionDate) {
		this.dissolutionDate = dissolutionDate;
	}
	public ClubModel(String clubID, String clubName, String description, Timestamp createDate,
			Timestamp dissolutionDate) {
		super();
		this.clubID = clubID;
		this.clubName = clubName;
		this.description = description;
		this.createDate = createDate;
		this.dissolutionDate = dissolutionDate;
	}
	public ClubModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
