/**
 * 
 */
package de.todd.userdb.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import de.todd.userdb.model.Match;
import de.todd.userdb.model.Team;
import de.todd.userdb.services.TeamService;
import de.todd.userdb.util.Events.Added;
import de.todd.userdb.util.Events.Updated;

@SessionScoped
@Named
public class MatchEditController implements Serializable {

	private static final long serialVersionUID = 7695931210206074461L;

	@Inject
	private TeamService teamService;

	@Inject
	@Added
	private Event<Match> matchAddEventSrc;

	@Inject
	@Updated
	private Event<Match> matchUpdatedEventSrc;

	public enum Mode {
		EDIT, ADD
	};

	private Match match;
	private Mode mode;
	private Long teamId1;
	private Long teamID2;

	public Long getTeamId1() {
		return teamId1;
	}

	public void setTeamId1(Long teamId) {
		this.teamId1 = teamId;
	}

	public Long getTeamId2() {
		return teamID2;
	}

	public void setTeamId2(Long teamID) {
		this.teamID2 = teamID;
	}

	public Mode getMode() {
		return mode;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatchToEdit(Mode mode) {
		this.setMatchToEdit(mode, new Match());
	}

	public void setMatchToEdit(Mode mode, Match match) {
		this.match = match;
		this.mode = mode;

	}

	public String doSave() {
		if (this.getMode() == Mode.ADD) {
			Team team1 = teamService.findTeamById(this.getTeamId1());
			Team team2 = teamService.findTeamById(this.getTeamId2());
			match.setTeam1(team1);
			match.setTeam2(team2);
			matchAddEventSrc.fire(match);
		} else {
			matchUpdatedEventSrc.fire(match);
		}
		return Pages.TEAM_LIST;
	}

	public String doCancel() {
		return Pages.USER_LIST;
	}

	public String getTitle() {
		return this.getMode() == Mode.EDIT ? "Match editieren"
				: "Neues Match anlegen";
	}
}
