package de.todd.userdb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.todd.userdb.model.Group;
import de.todd.userdb.model.Team;

@Stateless
public class GroupServiceBean implements GroupService {

	@Inject
	EntityManager entityManager;

	@Override
	public List<Group> getAllGroups() {
		TypedQuery<Group> query = entityManager.createNamedQuery(Group.findAll,
				Group.class);
		List<Group> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public void addGroup(Group entity) {
		System.out.println("GroupServiceBean.addGroup " + entity.getLetter()
				+ "; id: " + entity.getId());
		entityManager.persist(entity);
	}

	@Override
	public void deleteGroup(Group entity) {
		Group managedTeam = entityManager.find(Group.class, entity.getId());
		entityManager.remove(managedTeam);
	}

	@Override
	public void updateGroup(Group entity) {
		for (Team team : entity.getTeams()) {
			entityManager.merge(team);
		}
		entityManager.merge(entity);
	}

}
