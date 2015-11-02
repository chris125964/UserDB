/**
 * 
 */
package de.todd.userdb.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import de.todd.userdb.controller.UserEditController.Mode;
import de.todd.userdb.model.User;
import de.todd.userdb.util.Events.Deleted;

/**
 * @author Christian
 *
 */
@SessionScoped
@Named
public class UserListController implements Serializable {

	private static final long serialVersionUID = -4665182135603490207L;

	private User userToDelete;

	@Inject
	private UserEditController userEditController;

	@Inject
	@Deleted
	private Event<User> userDeleteEventSrc;

	public String doAddUser() {
		userEditController.setUserToEdit(Mode.ADD);
		return Pages.USER_EDIT;
	}

	public String doEditUser(User user) {
		userEditController.setUserToEdit(Mode.EDIT, user);
		return Pages.USER_EDIT;
	}

	public String doListUser() {
		return Pages.USER_LIST;
	}

	public void doDeleteUser(User user) {
		this.userToDelete = user;
	}

	public void commitDeleteUser() {
		this.userDeleteEventSrc.fire(userToDelete);
	}
}
