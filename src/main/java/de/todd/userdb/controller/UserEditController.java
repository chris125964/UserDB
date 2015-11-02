/**
 * 
 */
package de.todd.userdb.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import de.todd.userdb.model.User;
import de.todd.userdb.util.Events.Added;
import de.todd.userdb.util.Events.Updated;

@SessionScoped
@Named
public class UserEditController implements Serializable {

	private static final long serialVersionUID = 3618976578947666365L;

	@Inject
	@Added
	private Event<User> userAddEventSrc;

	@Inject
	@Updated
	private Event<User> userUpdatedEventSrc;

	public enum Mode {
		EDIT, ADD
	};

	private User user;
	private Mode mode;

	public Mode getMode() {
		return mode;
	}

	public User getUser() {
		return user;
	}

	public void setUserToEdit(Mode mode) {
		this.setUserToEdit(mode, new User());
	}

	public void setUserToEdit(Mode mode, User user) {
		this.user = user;
		this.mode = mode;

	}

	public String doSave() {
		if (this.getMode() == Mode.ADD) {
			userAddEventSrc.fire(user);
		} else {
			userUpdatedEventSrc.fire(user);
		}
		return Pages.USER_LIST;
	}

	public String doCancel() {
		return Pages.USER_LIST;
	}

	public String getTitle() {
		return this.getMode() == Mode.EDIT ? "User editieren"
				: "Neuen User anlegen";
	}
}
