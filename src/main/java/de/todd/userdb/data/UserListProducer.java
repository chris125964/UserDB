package de.todd.userdb.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

import de.todd.userdb.model.User;
import de.todd.userdb.services.UserService;
import de.todd.userdb.util.Events.Added;
import de.todd.userdb.util.Events.Deleted;
import de.todd.userdb.util.Events.Updated;

@RequestScoped
@Named
public class UserListProducer {

	@Inject
	private UserService userService;

	private List<User> userList;

	@PostConstruct
	public void init() {
		userList = userService.getAllUser();
	}

	public List<User> getUser() {
		return userList;
	}

	public void onUserAdded(@Observes @Added User user) {
		userService.addUser(user);
		init();
	}

	public void onUserDeleted(@Observes @Deleted User user) {
		userService.deleteUser(user);
		init();
	}

	public void onUserUpdated(@Observes @Updated User user) {
		userService.updateUser(user);
		init();
	}

}
