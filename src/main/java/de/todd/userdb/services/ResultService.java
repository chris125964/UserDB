package de.todd.userdb.services;

import java.util.List;

import de.todd.userdb.model.Result;

public interface ResultService {

	List<Result> getAllResults();

	void addResult(Result result);

	void deleteResult(Result result);

	void updateResult(Result grresultoup);

}
