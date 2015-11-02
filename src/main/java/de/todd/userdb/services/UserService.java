package de.todd.userdb.services;

import java.util.List;

import de.todd.userdb.model.User;

public interface UserService {

	List<User> getAllUser();

	void addUser(User user);

	void deleteUser(User user);

	void updateUser(User user);
}
