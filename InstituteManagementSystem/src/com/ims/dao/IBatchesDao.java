package com.ims.dao;

import java.util.List;

import com.ims.actions.Batches;

public interface IBatchesDao {

	List<Batches> readDataFromDb();
	List<Batches> getAllData();
	Batches addBatch(Batches b);
}
