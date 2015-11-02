/**
 * 
 */
package de.todd.userdb.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import de.todd.userdb.controller.GroupEditController.Mode;
import de.todd.userdb.model.Group;
import de.todd.userdb.util.Events.Deleted;

/**
 * @author Christian
 *
 */
@SessionScoped
@Named
public class GroupListController implements Serializable {

	private static final long serialVersionUID = -75399852560195852L;

	private Group groupToDelete;

	@Inject
	private GroupEditController groupEditController;

	@Inject
	@Deleted
	private Event<Group> groupDeleteEventSrc;

	public String doAddGroup() {
		groupEditController.setGroupToEdit(Mode.ADD);
		return Pages.GROUP_EDIT;
	}

	public String doEditTeam(Group group) {
		groupEditController.setGroupToEdit(Mode.EDIT, group);
		return Pages.GROUP_EDIT;
	}

	public String doListGroup() {
		return Pages.GROUP_LIST;
	}

	public void doDeleteGroup(Group group) {
		this.groupToDelete = group;
	}

	public void doCommitDeleteGroup() {
		this.groupDeleteEventSrc.fire(groupToDelete);
	}
}
