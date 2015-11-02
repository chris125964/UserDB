package de.todd.userdb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.todd.userdb.model.User;

@Stateless
public class UserServiceBean implements UserService {

	@Inject
	EntityManager entityManager;

	@Override
	public List<User> getAllUser() {
		TypedQuery<User> query = entityManager.createNamedQuery(User.findAll,
				User.class);
		List<User> users = query.getResultList();
		return users;
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void deleteUser(User user) {
		User managedUser = entityManager.find(User.class, user.getEmail());
		entityManager.remove(managedUser);
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

}
