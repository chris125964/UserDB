package de.todd.userdb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.todd.userdb.model.Result;

@Stateless
public class ResultServiceBean implements ResultService {

	@Inject
	EntityManager entityManager;

	@Override
	public List<Result> getAllResults() {
		TypedQuery<Result> query = entityManager.createNamedQuery(
				Result.findAll, Result.class);
		List<Result> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public void addResult(Result result) {
		System.out.println("ResultServiceBean.addResult " + result.getUser()
				+ "; id: " + result.getId());
		entityManager.persist(result);
	}

	@Override
	public void deleteResult(Result result) {
		Result managedResult = entityManager.find(Result.class, result.getId());
		entityManager.remove(managedResult);
	}

	@Override
	public void updateResult(Result result) {
		entityManager.merge(result);
	}

}
