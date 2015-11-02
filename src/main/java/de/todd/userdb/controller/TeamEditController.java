/**
 * 
 */
package de.todd.userdb.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import de.todd.userdb.model.Team;
import de.todd.userdb.util.Events.Added;
import de.todd.userdb.util.Events.Updated;

@SessionScoped
@Named
public class TeamEditController implements Serializable {

	private static final long serialVersionUID = 458879259578374545L;

	@Inject
	@Added
	private Event<Team> teamAddEventSrc;

	@Inject
	@Updated
	private Event<Team> teamUpdatedEventSrc;

	public enum TeamMode {
		EDIT, ADD
	};

	private Team team;
	private TeamMode mode;

	public TeamMode getMode() {
		return mode;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeamToEdit(TeamMode mode) {
		this.setTeamToEdit(mode, new Team());
	}

	public void setTeamToEdit(TeamMode mode, Team team) {
		this.team = team;
		this.mode = mode;

	}

	public String doSave() {
		if (this.getMode() == TeamMode.ADD) {
			teamAddEventSrc.fire(team);
		} else {
			teamUpdatedEventSrc.fire(team);
		}
		return Pages.TEAM_LIST;
	}

	public String doCancel() {
		return Pages.TEAM_LIST;
	}

	public String getTitle() {
		return this.getMode() == TeamMode.EDIT ? "Team editieren"
				: "Neues Team anlegen";
	}
}
