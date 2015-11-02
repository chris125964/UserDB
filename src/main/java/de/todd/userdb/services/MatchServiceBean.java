package de.todd.userdb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.todd.userdb.model.Match;

@Stateless
public class MatchServiceBean implements MatchService {

	@Inject
	EntityManager entityManager;

	@Override
	public List<Match> getAllMatches() {
		TypedQuery<Match> query = entityManager.createNamedQuery(Match.findAll,
				Match.class);
		List<Match> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public void addMatch(Match entity) {
		entityManager.persist(entity);
	}

	@Override
	public void deleteMatch(Match entity) {
		Match managedTeam = entityManager.find(Match.class, entity.getId());
		entityManager.remove(managedTeam);
	}

	@Override
	public void updateMatch(Match entity) {
		entityManager.merge(entity);
	}

}
