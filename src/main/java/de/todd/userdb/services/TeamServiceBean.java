package de.todd.userdb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.todd.userdb.model.Team;

@Stateless
public class TeamServiceBean implements TeamService {

	@Inject
	EntityManager entityManager;

	@Override
	public List<Team> getAllTeams() {
		TypedQuery<Team> query = entityManager.createNamedQuery(Team.findAll,
				Team.class);
		List<Team> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public void addTeam(Team team) {
		entityManager.persist(team);

	}

	@Override
	public void deleteTeam(Team team) {
		Team managedTeam = entityManager.find(Team.class, team.getId());
		entityManager.remove(managedTeam);
	}

	@Override
	public void updateTeam(Team team) {
		entityManager.merge(team);
	}

	@Override
	public Team findTeamById(Long id) {
		Team team = entityManager.find(Team.class, id);
		return team;
	}

}
