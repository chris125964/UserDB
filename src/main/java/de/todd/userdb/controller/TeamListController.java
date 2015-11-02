/**
 * 
 */
package de.todd.userdb.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import de.todd.userdb.controller.TeamEditController.TeamMode;
import de.todd.userdb.model.Team;
import de.todd.userdb.util.Events.Deleted;

/**
 * @author Christian
 *
 */
@SessionScoped
@Named
public class TeamListController implements Serializable {

	private static final long serialVersionUID = 1555221761090769372L;

	private Team teamToDelete;

	@Inject
	private TeamEditController teamEditController;

	@Inject
	@Deleted
	private Event<Team> teamDeleteEventSrc;

	public String doAddTeam() {
		teamEditController.setTeamToEdit(TeamMode.ADD);
		return Pages.TEAM_EDIT;
	}

	public String doEditTeam(Team team) {
		teamEditController.setTeamToEdit(TeamMode.EDIT, team);
		return Pages.TEAM_EDIT;
	}

	public String doListTeam() {
		return Pages.TEAM_LIST;
	}

	public void doDeleteTeam(Team team) {
		this.teamToDelete = team;
	}

	public void doCommitDeleteTeam() {
		this.teamDeleteEventSrc.fire(teamToDelete);
	}
}
