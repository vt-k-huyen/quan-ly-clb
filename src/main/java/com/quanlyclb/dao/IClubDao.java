package com.quanlyclb.dao;

import java.util.List;

import com.quanlyclb.model.ClubModel;
import com.quanlyclb.paging.Pageble;

public interface IClubDao extends GenericDao<ClubModel>{
	List<ClubModel> findAll();
	List<ClubModel> findAll(Pageble pageble);
	ClubModel findOne(String clubID);
	void save(ClubModel clubModel);
	void update(ClubModel updateClub);
	void delete(String clubID);
	int getTotalItem();
	List<ClubModel> findClubs(String memberID, Pageble pageble);
}
