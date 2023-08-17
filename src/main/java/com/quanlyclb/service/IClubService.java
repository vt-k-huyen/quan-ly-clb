package com.quanlyclb.service;

import java.util.List;

import com.quanlyclb.model.ClubModel;
import com.quanlyclb.paging.Pageble;

public interface IClubService {
	List<ClubModel> findAll();
	List<ClubModel> findAll(Pageble pageble);
	ClubModel findOne(String clubID);
	ClubModel save(ClubModel clubModel);
	ClubModel update(ClubModel updateClub);
	void delete(String clubID);
	int getTotalItem();	
	List<ClubModel> findClubs(String memberID, Pageble pageble);
	int count(String memberID, Pageble pageble);
}
