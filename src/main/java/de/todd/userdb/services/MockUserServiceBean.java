package de.todd.userdb.services;

import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

import de.todd.userdb.model.User;

@RequestScoped
@Alternative
public class MockUserServiceBean implements UserService {

	@Override
	public List<User> getAllUser() {
		User user1 = new User();
		user1.setVorname("Wolfgang");
		user1.setNachname("Todd");

		User user2 = new User();
		user2.setVorname("Helga");
		user2.setNachname("Todd");

		List<User> ret = new LinkedList<User>();
		ret.add(user1);
		ret.add(user2);
		return ret;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

}
